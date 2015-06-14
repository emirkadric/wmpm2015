package com.workflow2015.service.impl.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by kumar on 10/06/15.
 */
@Component
public class AddLineBreakProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        body = String.format("%s%s", body, System.getProperty("line.separator"));
        exchange.getIn().setBody(body);
    }
}
