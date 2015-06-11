package com.workflow2015.service.impl.processor;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsRoute;
import com.workflow2015.common.directions.DirectionsDTO;
import com.workflow2015.common.directions.DirectionsLegDTO;
import com.workflow2015.common.directions.DirectionsStepDTO;
import com.workflow2015.common.helper.RouteRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by kumar on 10/06/15.
 */
@Component
public class DirectionsProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        RouteRequest routeRequest = exchange.getIn().getBody(RouteRequest.class);

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDqa7u_SLmSiEPL7dEVfaqicXCh7r6t-Ks");
        DirectionsRoute[] results = DirectionsApi.getDirections(context, routeRequest.getFrom().toString(), routeRequest.getTo().toString()).await();
        //log.debug(results.length > 0 ? results[0].toString() : "no route found");
        DirectionsDTO directions = new DirectionsDTO();
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].legs.length; j++) {
                String duration = results[i].legs[j].duration.humanReadable;
                String distance = results[i].legs[j].distance.humanReadable;
                DirectionsLegDTO leg = new DirectionsLegDTO(duration, distance);
                for (int k = 0; k < results[i].legs[j].steps.length; k++) {
                    String durationStep = results[i].legs[j].steps[k].duration.humanReadable;
                    String distanceStep = results[i].legs[j].steps[k].distance.humanReadable;
                    String directionsHTML = results[i].legs[j].steps[k].htmlInstructions;
                    DirectionsStepDTO step = new DirectionsStepDTO(durationStep, distanceStep, directionsHTML);
                    leg.addStep(step);

                }
                directions.addLeg(leg);
            }
        }
        if (results.length > 0)
            exchange.getIn().setBody(directions);
    }
}
