package com.workflow2015.service.impl.processor;

import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.common.helper.RouteRequestBeanValidator;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kumar on 11/06/15.
 */
@Component
public class RouteRequestValidatorProcessor implements Processor {

    @Autowired
    RouteRequestBeanValidator validator;
    @Override
    public void process(Exchange exchange) throws ValidationException {

        RouteRequest request = exchange.getIn().getBody(RouteRequest.class);

        Map<String,String> map = new HashMap<>();
        MapBindingResult err = new MapBindingResult(map, RouteRequest.class.getName());
        validator.validate(request,err);
        List<ObjectError> list = err.getAllErrors();
        for(ObjectError objErr : list){
            throw new ValidationException(exchange,objErr.getCode());
        }




    }
}
