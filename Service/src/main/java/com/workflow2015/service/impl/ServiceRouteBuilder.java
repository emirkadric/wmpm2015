package com.workflow2015.service.impl;

import com.workflow2015.service.impl.openweathermap.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/11/15.
 */
@Component
public class ServiceRouteBuilder extends org.apache.camel.builder.RouteBuilder {

    @Autowired
    private OpenWeatherMap openWeatherMap;

    @Override
    public void configure() throws Exception {
        from("rabbitmq://localhost/bptexchange?exchangeType=topic&queue=bptoutgoing&routingKey=openweathermap").
                process(openWeatherMap);
    }
}
