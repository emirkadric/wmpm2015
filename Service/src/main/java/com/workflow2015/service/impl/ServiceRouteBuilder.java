package com.workflow2015.service.impl;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsRoute;
import com.workflow2015.common.directions.DirectionsDTO;
import com.workflow2015.common.directions.DirectionsLegDTO;
import com.workflow2015.common.directions.DirectionsStepDTO;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.common.helper.Xml2JsonConfiguration;
import com.workflow2015.service.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.common.citybike.CityBikeStation;
import com.workflow2015.common.openweathermap.OpenWeather;
import com.workflow2015.common.wienerlinien.Wienerlinien;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationFilter;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationJsonParser;
import com.workflow2015.service.impl.openweathermap.OpenWeatherMapService;
import com.workflow2015.service.impl.wienerlinien.WienerLinienService;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.component.restlet.RestletConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.restlet.Request;
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

        
        //add logging
        from("activemq:queue:log")
        .setHeader(Exchange.FILE_NAME, constant("requests.txt"))
                .process(exchange -> {
                    Long ts = exchange.getIn().getHeader("org.restlet.startTime", Long.class);
                    String body = exchange.getIn().getBody(String.class);
                    //String ts = exchange.getIn().getHeader()
                    body = String.format("%s: %s%s", new Date(ts),body,System.getProperty("line.separator"));
                    exchange.getIn().setBody(body);
                })
                .to("file://log?fileExist=Append")

        .end();

        from("activemq:topic:routerequest.directions")
                .process(exchange -> {
                    RouteRequest routeRequest = exchange.getIn().getBody(RouteRequest.class);

                    GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDqa7u_SLmSiEPL7dEVfaqicXCh7r6t-Ks");
                    DirectionsRoute[] results = DirectionsApi.getDirections(context, routeRequest.getFrom().toString(), routeRequest.getTo().toString()).await();
                    log.debug(results.length > 0 ? results[0].toString() : "no route found");
                    DirectionsDTO directions = new DirectionsDTO();
                    for (int i = 0; i < results.length; i++) {
                        for (int j = 0; j < results[i].legs.length; j++) {
                            String duration = results[i].legs[j].duration.humanReadable;
                            String distance = results[i].legs[j].distance.humanReadable;
                            DirectionsLegDTO leg = new DirectionsLegDTO(duration,distance);
                            for (int k = 0; k < results[i].legs[j].steps.length; k++) {
                                String durationStep = results[i].legs[j].steps[k].duration.humanReadable;
                                String distanceStep = results[i].legs[j].steps[k].distance.humanReadable;
                                String directionsHTML = results[i].legs[j].steps[k].htmlInstructions;
                                DirectionsStepDTO step = new DirectionsStepDTO(durationStep, distanceStep,directionsHTML);
                                leg.addStep(step);

                            }
                            directions.addLeg(leg);
                        }
                    }
                    if (results.length > 0)
                        exchange.getIn().setBody(directions);
                })
                .end();

        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .recipientList(header("wienerlinienuri"))
                .unmarshal().json(JsonLibrary.Gson, Wienerlinien.class)
                .end();

    }
}
