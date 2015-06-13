package com.workflow2015.service.impl;

import com.workflow2015.common.openweathermap.OpenWeather;
import com.workflow2015.common.wienerlinien.Wienerlinien;
import com.workflow2015.service.impl.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.service.impl.processor.CityBikeStationFilter;
import com.workflow2015.service.impl.processor.CityBikeStationJsonParser;
import com.workflow2015.service.impl.processor.DirectionsProcessor;
import com.workflow2015.service.impl.processor.AddLineBreakProcessor;
import com.workflow2015.service.impl.processor.OpenWeatherMapService;
import com.workflow2015.service.impl.processor.WienerLinienService;
import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
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
    @Autowired
    private CityBikeStationJsonParser cityBikeStationJsonParser;
    @Autowired
    private CityBikeStationFilter cityBikeStationFilter;
    @Autowired
    private DirectionsProcessor directionsProcessor;
    @Autowired
    private AddLineBreakProcessor addLineBreakProcessor;


    @Override
    public void configure() throws Exception {

        //Log all incoming requests with timestamp
        from("activemq:queue:log")
                .setHeader(Exchange.FILE_NAME, constant("requests.txt"))
                .transform().simple("${in.header.org.restlet.startTime}: ${body}")
                .process(addLineBreakProcessor)
                .to("file://log?fileExist=Append")
                .end();

        //Fetch Weather data
        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService)
                .recipientList(header("openweathermapuri"))
                .unmarshal().json(JsonLibrary.Gson, OpenWeather.class)
                .end();

        //Fetch Citybikes
        from("activemq:topic:routerequest.citybike")
                .enrich("restlet:http://api.citybik.es/citybike-wien.json",
                        new CityBikeStationAggregationStrategy()) //needed to store the original request
                .process(cityBikeStationJsonParser)
                .process(cityBikeStationFilter)
                .end();

        //Fetch Directions of maps-api
        from("activemq:topic:routerequest.directions")
                .process(directionsProcessor)
                .end();


        //Fetch Directions for subway
        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .recipientList(header("wienerlinienuri"))
                .unmarshal().json(JsonLibrary.Gson, Wienerlinien.class)
<<<<<<< HEAD
                .end();
=======
                .to("activemq:topic:requestprocessing.wienerlinien");

       /* from("activemq:topic:requestprocessing.wienerlinien").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                /*Wienerlinien test = exchange.getIn().getBody(Wienerlinien.class);
                exchange.getOut().setHeader("wienerlinien", "location");
                exchange.getOut().setBody(exchange.getIn().getBody(String.class));
            }
        }).to("jpa:User");*/
>>>>>>> feature/emailAdvertising

    }
}
