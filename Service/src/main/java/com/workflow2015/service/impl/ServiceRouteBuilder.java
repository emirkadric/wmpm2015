package com.workflow2015.service.impl;

import com.workflow2015.service.impl.openweathermap.OpenWeatherMapService;
import com.workflow2015.service.impl.wienerlinien.WienerLinienService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/11/15.
 */
@Component
public class ServiceRouteBuilder extends org.apache.camel.builder.RouteBuilder {

    @Autowired
    private OpenWeatherMapService openWeatherMapService;
    @Autowired
    private WienerLinienService wienerLinienService;

    @Override
    public void configure() throws Exception {
        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService);
        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .to("activemq:topic:requestprocessing.wienerlinien");
        from("activemq:topic:requestprocessing.wienerlinien").marshal().xmljson()/*.process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getOut().setHeader("wienerlinien", "location");
            }
        })*/.to("activemq:topic:routerequest.wienerlinien");
    }
}
