package com.workflow2015.service.impl.processor;

import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dominik Heigl on 5/21/15.
 */
@Component
public class WienerLinienService implements Processor {
    private static final Logger log = LoggerFactory.getLogger(WienerLinienService.class);

    private final CamelContext camelContext;

    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Autowired
    public WienerLinienService(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    private String uriBuilder(RouteRequest routeRequest) {
        Date date = new Date((long) routeRequest.getTime() * 1000);
        String time = new SimpleDateFormat("HHmm").format(date);
        String d = new SimpleDateFormat("yyyyMMdd").format(date);
        return "restlet:http://www.wienerlinien.at/ogd_routing/XML_TRIP_REQUEST2?itdDate=" + d + "&itdTime=" + time + "&type_origin=coord&name_origin=" + routeRequest.getFrom().getLongitude() + ":" + routeRequest.getFrom().getLatitude() + ":WGS84&type_destination=coord&name_destination=" + routeRequest.getTo().getLongitude() + ":" + routeRequest.getTo().getLatitude() + ":WGS84&outputFormat=JSON";
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        RouteRequest routeRequest = exchange.getIn().getBody(RouteRequest.class);
        exchange.getIn().setHeader("wienerlinienuri", this.uriBuilder(routeRequest));
        exchange.getIn().setBody(routeRequest, RouteRequest.class);


    }
}
