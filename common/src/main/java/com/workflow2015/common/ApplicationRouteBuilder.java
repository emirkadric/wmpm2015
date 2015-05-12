package com.workflow2015.common;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/7/15.
 */
@Component
public class ApplicationRouteBuilder extends org.apache.camel.builder.RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost/bptexchange?exchangeType=topic&queue=bptincoming&routingKey=routerequestresult").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getIn().getBody(String.class));
            }
        });

        from("restlet:http://localhost:" + 49081 + "/routerequest?restletMethod=post").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                //TODO Unnecessary json parse?
                String json = exchange.getIn().getBody(String.class);
                RouteRequest routeRequest = JsonHelper.gson.fromJson(json, RouteRequest.class);
                exchange.getOut().setBody(JsonHelper.gson.toJson(routeRequest, RouteRequest.class));
                exchange.getOut().setHeader("rabbitmq.ROUTING_KEY", "openweathermap");
            }
        })//TODO add additional routes
                .to("rabbitmq://localhost/bptexchange?exchangeType=topic&queue=bptoutgoing");


    }
}
