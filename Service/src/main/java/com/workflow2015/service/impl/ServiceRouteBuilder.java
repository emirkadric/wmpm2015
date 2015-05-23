package com.workflow2015.service.impl;

import com.workflow2015.service.impl.citybike.CityBikeService;
import com.workflow2015.service.impl.openweathermap.OpenWeatherMapService;
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
    private CityBikeService cityBikeService;

    @Override
    public void configure() throws Exception {
        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService);
        from("activemq:topic:routerequest.citybike").
                process(cityBikeService);
    }
}
