package com.workflow2015.service.impl.processor;

import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.common.citybike.CityBikeStation;
import com.workflow2015.common.citybike.CityBikeStations;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kumar on 23/05/15.
 */
@Component
public class CityBikeStationFilter implements Processor {

    private static final Logger log = LoggerFactory.getLogger(CityBikeStationFilter.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        //todo filter data
        RouteRequest rootRequest = exchange.getProperty("rootRequest", RouteRequest.class);
        CityBikeStations stations = exchange.getIn().getBody(CityBikeStations.class);
        CityBikeStation closest = stations.getClosestBikeStation(rootRequest.getFrom().getLongitude(),
                rootRequest.getFrom().getLatitude());

        log.debug(closest.toString());
        exchange.getIn().setBody(closest);
    }
}
