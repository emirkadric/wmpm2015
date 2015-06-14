package com.workflow2015.common.helper;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kumar on 11/06/15.
 */
@Component
public class RouteRequestBeanValidator implements Validator {

    final String pattern = "^\\d{1,2}\\.\\d{5}$";
    final String tsPattern = "^\\d{10}$";

    @Override
    public boolean supports(Class<?> aClass) {
        return RouteRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RouteRequest request = (RouteRequest) o;

        if(request.getFrom() == null){
            errors.rejectValue("from", "From Coordinates missing");
            return;
        }

        if(request.getTo() == null) {
            errors.rejectValue("to", "To Coordinates missing");
            return;
        }
        if(request.getFrom().getLatitude()==null) {
            errors.rejectValue("from.latitude", "From.latitude missing");
            return;
        }
        if(request.getFrom().getLongitude()==null) {
            errors.rejectValue("from.longitude", "From.longitude missing");
            return;
        }
        if(request.getTo().getLatitude()==null) {
            errors.rejectValue("to.longitude", "To.longitude missing");
            return;
        }
        if(request.getTo().getLongitude()==null) {
            errors.rejectValue("to.longitude", "To.longitude missing");
            return;
        }
        if(request.getTime()==null) {
            errors.rejectValue("time", "Time missing");
            return;
        }




        if (!request.getFrom().getLatitude().toString().matches(pattern))
            errors.rejectValue("from.latitude", "From Latitude wrong Coordinate format");
        if (!request.getFrom().getLongitude().toString().matches(pattern))
            errors.rejectValue("from.longitude", "From Longitude wrong Coordinate format");
        if (!request.getTo().getLatitude().toString().matches(pattern))
            errors.rejectValue("to.latitude", "To Latitude wrong Coordinate format");
        if (!request.getTo().getLongitude().toString().matches(pattern))
            errors.rejectValue("to.longitude", "To Longitude wrong Coordinate format");

        if (!request.getTime().toString().matches(tsPattern))
            errors.rejectValue("timestamp", "No timestamp supplied");
    }
}
