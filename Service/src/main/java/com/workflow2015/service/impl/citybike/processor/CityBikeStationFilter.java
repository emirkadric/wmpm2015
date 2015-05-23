package com.workflow2015.service.impl.citybike.processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.helper.citybike.CityBikeStation;
import com.workflow2015.service.helper.citybike.CityBikeStations;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kumar on 23/05/15.
 */
@Component
public class CityBikeStationFilter implements Processor {

    private static final Logger log = LoggerFactory.getLogger(CityBikeStationFilter.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        //todo filter data
        RouteRequest rootRequest = exchange.getProperty("rootRequest",RouteRequest.class);
        CityBikeStations stations = exchange.getIn().getBody(CityBikeStations.class);
        CityBikeStation closest = stations.getClosestBikeStation(rootRequest.getFrom().getLongitude(),
                rootRequest.getFrom().getLatitude());

        log.debug(closest.toString());
        exchange.getIn().setBody(closest);
    }
}