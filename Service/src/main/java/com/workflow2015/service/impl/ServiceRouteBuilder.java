package com.workflow2015.service.impl;

import com.workflow2015.common.helper.Xml2JsonConfiguration;
import com.workflow2015.service.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.service.aggregator.OpenWeatherMapAggregationStrategy;
import com.workflow2015.service.helper.citybike.CityBikeStation;
import com.workflow2015.service.helper.openweathermap.OpenWeather;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationFilter;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationJsonParser;
import com.workflow2015.service.impl.openweathermap.OpenWeatherMapService;
import com.workflow2015.service.impl.wienerlinien.WienerLinienService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
    private Xml2JsonConfiguration xml2JsonConfiguration;
    /*@Autowired
    private OpenWeatherMapAggregationStrategy openWeatherMapAggregationStrategy;*/


    @Override
    public void configure() throws Exception {
//        errorHandler(deadLetterChannel("activemq:topic:error"));

        from("activemq:topic:error").setHeader(Exchange.FILE_NAME, constant("log.txt")).to("file:etc/log?fileExist=Append");

        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService)
                .to("activemq:topic:requestprocessing.openweathermap");

        from("activemq:topic:requestprocessing.openweathermap")
                .recipientList(header("openweathermapuri")).aggregationStrategy(new OpenWeatherMapAggregationStrategy())
                .unmarshal().json(JsonLibrary.Gson, OpenWeather.class)
                .to("activemq:topic:result.openweathermap");

        from("activemq:topic:result.openweathermap")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        OpenWeather openWeather = exchange.getIn().getBody(OpenWeather.class);
                    }
                });

        from("activemq:topic:routerequest.citybike")
                .enrich("restlet:http://api.citybik.es/citybike-wien.json", new CityBikeStationAggregationStrategy())
                .process(cityBikeStationJsonParser)
                .process(cityBikeStationFilter)
                .to("activemq:topic:requestprocessing.citybike");

        from("activemq:topic:requestprocessing.citybike")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        CityBikeStation station = exchange.getIn().getBody(CityBikeStation.class);
                    }
                });

        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .to("activemq:topic:requestprocessing.wienerlinien");

        from("activemq:topic:requestprocessing.wienerlinien").marshal().xmljson(xml2JsonConfiguration.getXmlJsonOptions()).process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getOut().setHeader("wienerlinien", "location");
                exchange.getOut().setBody(exchange.getIn().getBody(String.class));
            }
        }).to("activemq:topic:routerequest.wienerlinien");
    }
}
