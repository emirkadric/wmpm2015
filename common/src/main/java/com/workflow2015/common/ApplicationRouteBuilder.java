package com.workflow2015.common;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/7/15.
 */
@Component
public class ApplicationRouteBuilder extends org.apache.camel.builder.RouteBuilder {

    private static final Logger log = LoggerFactory.getLogger(ApplicationRouteBuilder.class);


    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public void configure() throws Exception {
        from("activemq:topic:routerequest.result").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                log.debug("routerequest.result: " + exchange.getIn().getBody(String.class));
            }
        });

        from("restlet:http://localhost:" + 49081 + "/routerequest?restletMethod=post").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                //TODO Unnecessary json parse?
                String json = exchange.getIn().getBody(String.class);
                RouteRequest routeRequest = JsonHelper.gson.fromJson(json, RouteRequest.class);
                exchange.getOut().setBody(JsonHelper.gson.toJson(routeRequest, RouteRequest.class), String.class);
            }
        })//TODO add additional routes
                .multicast()
                .to("activemq:topic:routerequest.openweathermap", "activemq:topic:routerequest.wienerlinien", "activemq:topic:routerequest.citybike");


    }
}
