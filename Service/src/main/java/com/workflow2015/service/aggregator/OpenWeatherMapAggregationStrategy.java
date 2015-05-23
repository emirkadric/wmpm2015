package com.workflow2015.service.aggregator;

import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created by Dominik Heigl on 23/05/15.
 */
public class OpenWeatherMapAggregationStrategy implements AggregationStrategy {

    public OpenWeatherMapAggregationStrategy() {
    }

    @Override
    public Exchange aggregate(Exchange original, Exchange resource) {
        if (original != null) {
            RouteRequest rootRequest = original.getIn().getBody(RouteRequest.class);
            resource.setProperty("rootRequest", rootRequest);
        }
        return resource;
    }
}
