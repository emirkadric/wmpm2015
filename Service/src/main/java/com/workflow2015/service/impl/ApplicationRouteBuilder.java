package com.workflow2015.service.impl;

import com.workflow2015.common.DecisionMaker;
import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import com.workflow2015.service.impl.processor.RouteRequestValidatorProcessor;
import org.apache.camel.ValidationException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/7/15.
 */
@Component
public class ApplicationRouteBuilder extends RouteBuilder {

    @Autowired
    private RouteRequestValidatorProcessor routeRequestValidator;
    @Override
    public void configure() throws Exception {

        from("restlet:http://localhost:" + 49081 + "/routerequest?restletMethod=post")
                .wireTap("activemq:queue:log")
                .choice()
                    .when(simple("${body} != null")) //message filter
                        .unmarshal().json(JsonLibrary.Gson, RouteRequest.class)
                            .doTry()
                                .process(routeRequestValidator)
                            .doCatch(ValidationException.class)
                                .transform().simple("${exception.message}")
                                .endChoice()
                            .multicast(new GroupedExchangeAggregationStrategy())
                            .parallelProcessing()
                            .to("activemq:topic:routerequest.openweathermap",
                                    "activemq:topic:routerequest.wienerlinien",
                                    "activemq:topic:routerequest.citybike",
                                    "activemq:topic:routerequest.directions")
                            .end()
                            .bean(DecisionMaker.class, "decide(${body})")
                            .marshal().json(JsonLibrary.Gson)
                .end();



    }
}
