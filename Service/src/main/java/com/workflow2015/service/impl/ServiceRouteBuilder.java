package com.workflow2015.service.impl;

<<<<<<< Updated upstream
import com.workflow2015.service.impl.citybike.CityBikeService;
=======
import com.workflow2015.common.helper.Xml2JsonConfiguration;
import com.workflow2015.service.aggregator.CityBikeStationAggregationStrategy;
import com.workflow2015.service.helper.citybike.CityBikeStations;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationFilter;
import com.workflow2015.service.impl.citybike.processor.CityBikeStationJsonParser;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private CityBikeService cityBikeService;
=======
    private CityBikeStationJsonParser cityBikeStationJsonParser;
    @Autowired
    private CityBikeStationFilter cityBikeStationFilter;
    @Autowired
    private Xml2JsonConfiguration xml2JsonConfiguration;

>>>>>>> Stashed changes

    @Override
    public void configure() throws Exception {
        from("activemq:topic:routerequest.openweathermap").
                process(openWeatherMapService);
<<<<<<< Updated upstream
        from("activemq:topic:routerequest.citybike").
                process(cityBikeService);
=======

        from("activemq:topic:routerequest.citybike")
                .enrich("restlet:http://api.citybik.es/citybike-wien.json", new CityBikeStationAggregationStrategy())
                .process(cityBikeStationJsonParser)
                .process(cityBikeStationFilter)
                .to("activemq:topic:requestprocessing.citybike");

        from("activemq:topic:requestprocessing.citybike")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        CityBikeStations stations = exchange.getIn().getBody(CityBikeStations.class);
                        log.debug(stations.toString());
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
>>>>>>> Stashed changes
    }
}
