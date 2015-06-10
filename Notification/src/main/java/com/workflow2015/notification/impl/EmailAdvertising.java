package com.workflow2015.notification.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emirk on 09/06/2015.
 */
@Component
public class EmailAdvertising implements Processor {

    private final CamelContext camelContext;

    @Autowired
    public EmailAdvertising(CamelContext camelContext){
        this.camelContext = camelContext;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("+++Email advertising processor!+++");

        Map<String, Object> emailHeader = new HashMap<String, Object>();

        emailHeader.put("To","wmpm2015@mailinator.com");
        emailHeader.put("Subject","Weekly Email offer just for YOU!");

        exchange.getIn().setHeaders(emailHeader);
        exchange.getIn().setBody("Hello dear friends!");

    }
}
