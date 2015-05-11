package com.workflow2015.common;

import com.google.gson.Gson;
import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/7/15.
 */
@Component
public class ApplicationRouteBuilder extends org.apache.camel.builder.RouteBuilder {


    private static final Gson gson = new Gson();

    @Override
    public void configure() throws Exception {
        from("restlet:http://localhost:" + 49081 + "/routerequest?restletMethod=post").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                String json = exchange.getIn().getBody(String.class);
                RouteRequest routeRequest = gson.fromJson(json, RouteRequest.class);
                exchange.getOut().setBody(gson.toJson(routeRequest, RouteRequest.class));
            }
        })//TODO add additional routes
                .to("rabbitmq://localhost/%2f?queue=bpt&routingKey=openweathermap");
    }
}
