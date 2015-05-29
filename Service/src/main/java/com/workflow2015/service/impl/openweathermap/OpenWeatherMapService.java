package com.workflow2015.service.impl.openweathermap;

import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dominik Heigl on 5/6/15.
 */
@org.springframework.stereotype.Component
public class OpenWeatherMapService implements Processor {

    private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapService.class);

    private final CamelContext camelContext;

    public CamelContext getCamelContext() {
        return camelContext;
    }


    //Example to read values from config file
    /*@Value("${openweathermap.url}")
    String url;*/

    @Autowired
    public OpenWeatherMapService(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    private String uriBuilder(RouteRequest routeRequest) {
        return "restlet:http://api.openweathermap.org/data/2.5/forecast?lat=" +
                routeRequest.getFrom().getLatitude() + "&lon=" +
                routeRequest.getFrom().getLongitude() +
                "&units=metric";
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        RouteRequest routeRequest = exchange.getIn().getBody(RouteRequest.class);
        exchange.getIn().setHeader("openweathermapuri", this.uriBuilder(routeRequest));
        exchange.getIn().setBody(routeRequest, RouteRequest.class);
    }
}