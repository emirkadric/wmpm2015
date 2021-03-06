package com.workflow2015.service.impl.aggregator;

import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created by kumar on 23/05/15.
 */
public class CityBikeStationAggregationStrategy implements AggregationStrategy {

    public CityBikeStationAggregationStrategy() {
    }

    @Override
    public Exchange aggregate(Exchange original, Exchange resource) {
        RouteRequest rootRequest = original.getIn().getBody(RouteRequest.class);
        resource.setProperty("rootRequest", rootRequest);
        return resource;
    }
}
