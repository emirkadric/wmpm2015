package com.workflow2015.common;

import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.model.dataformat.JsonLibrary;
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
        from("restlet:http://localhost:" + 49081 + "/routerequest?restletMethod=post")
                .unmarshal().json(JsonLibrary.Gson, RouteRequest.class)
                .multicast().parallelProcessing()
                .to("activemq:topic:routerequest.openweathermap",
                        "activemq:topic:routerequest.citybike");

    }
}
