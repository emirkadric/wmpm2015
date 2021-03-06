package com.workflow2015.notification.impl;

import com.workflow2015.database.model.IUser;
import com.workflow2015.database.model.User;
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
    public EmailAdvertising(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("+++Email advertising processor!+++");

        Map<String, Object> emailHeader = new HashMap<>();
        IUser o = exchange.getIn().getBody(User.class);

        emailHeader.put("To", o.getEmail());
        emailHeader.put("Subject", "Weekly Email offer just for YOU!");
        emailHeader.put("Content-Type", "text/html");

        exchange.getIn().setHeaders(emailHeader);

    }
}
