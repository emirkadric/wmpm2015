package com.workflow2015.service.impl;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsRoute;
import com.workflow2015.common.directions.DirectionsDTO;
import com.workflow2015.common.directions.DirectionsLegDTO;
import com.workflow2015.common.directions.DirectionsStepDTO;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.common.openweathermap.OpenWeather;
import com.workflow2015.common.wienerlinien.Wienerlinien;
import com.workflow2015.service.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationFilter;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationJsonParser;
import com.workflow2015.service.impl.directions.DirectionsProcessor;
import com.workflow2015.service.impl.logger.RequestLogger;
import com.workflow2015.service.impl.openweathermap.OpenWeatherMapService;
import com.workflow2015.service.impl.wienerlinien.WienerLinienService;
import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Dominik Heigl on 5/11/15.
 */
@Component
public class ServiceRouteBuilder extends org.apache.camel.builder.RouteBuilder {

    @Autowired
    private OpenWeatherMapService openWeatherMapService;
    @Autowired
    private WienerLinienService wienerLinienService;
    @Autowired
    private CityBikeStationJsonParser cityBikeStationJsonParser;
    @Autowired
    private CityBikeStationFilter cityBikeStationFilter;
    @Autowired
    private DirectionsProcessor directionsProcessor;
    @Autowired
    private RequestLogger requestLogger;


    @Override
    public void configure() throws Exception {
//        errorHandler(deadLetterChannel("activemq:topic:error"));

        from("activemq:topic:error").setHeader(Exchange.FILE_NAME, constant("log.txt")).to("file:etc/log?fileExist=Append");

        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService)
                .recipientList(header("openweathermapuri"))
                .unmarshal().json(JsonLibrary.Gson, OpenWeather.class)
                .end();

        from("activemq:topic:routerequest.citybike")
                .enrich("restlet:http://api.citybik.es/citybike-wien.json", new CityBikeStationAggregationStrategy())
                .process(cityBikeStationJsonParser)
                .process(cityBikeStationFilter)
                .end();

        //created processor to add new-line
        from("activemq:queue:log")
                .setHeader(Exchange.FILE_NAME, constant("requests.txt"))
                .transform().simple("${in.header.org.restlet.startTime}: ${body}")
                .process(requestLogger)
                .to("file://log?fileExist=Append")
                .end();

        from("activemq:topic:routerequest.directions")
                .process(directionsProcessor)
                .end();

        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .recipientList(header("wienerlinienuri"))
                .unmarshal().json(JsonLibrary.Gson, Wienerlinien.class)
                .end();

    }
}
