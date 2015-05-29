package com.workflow2015.service.impl;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsRoute;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.common.helper.Xml2JsonConfiguration;
import com.workflow2015.database.model.User;
import com.workflow2015.service.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.service.helper.citybike.CityBikeStation;
import com.workflow2015.service.helper.openweathermap.OpenWeather;
import com.workflow2015.service.helper.wienerlinien.Wienerlinien;
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
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        CityBikeStation station = exchange.getIn().getBody(CityBikeStation.class);
                    }
                });


        //add logging
        from("activemq:topic:log")
                .to("file://in?fileExist=Append")
                .end();

        from("activemq:topic:routerequest.directions")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        RouteRequest routeRequest = exchange.getIn().getBody(RouteRequest.class);

                        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDqa7u_SLmSiEPL7dEVfaqicXCh7r6t-Ks");
                        DirectionsRoute[] results = DirectionsApi.getDirections(context, routeRequest.getFrom().toString(), routeRequest.getTo().toString()).await();
                        log.debug(results.length > 0 ? results[0].toString() : "no route found");
                    }
                })
                .marshal().serialization()
                .end();

        from("activemq:topic:routerequest.wienerlinien").
                process(wienerLinienService)
                .recipientList(header("wienerlinienuri"))
//                .marshal().xmljson(xml2JsonConfiguration.getXmlJsonOptions())
                .unmarshal().json(JsonLibrary.Gson, Wienerlinien.class)
                .to("activemq:topic:requestprocessing.wienerlinien");

        from("activemq:topic:requestprocessing.wienerlinien").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                /*Wienerlinien test = exchange.getIn().getBody(Wienerlinien.class);
                exchange.getOut().setHeader("wienerlinien", "location");
                exchange.getOut().setBody(exchange.getIn().getBody(String.class));*/
                User u = new User();
                u.setFirstname("asdf");
                u.setLastname("jklo");
                u.setEmail("asdf@aksjdf.com");
                exchange.getIn().setBody(u, User.class);
            }
        }).to("jpa:User");

        from("jpa://User?consumer.query=select o from User o")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        log.info("Querying User");
                        User o = exchange.getIn().getBody(User.class);
                        log.info(o.toString());
                    }
                });
    }
}
