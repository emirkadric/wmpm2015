package com.workflow2015.notification.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by emirk on 13/05/2015.
 */
@Component
public class TwitterNotification implements Processor {
    private final CamelContext camelContext;
    private static AtomicInteger counter = new AtomicInteger((int) (Math.random() * 100));

    @Autowired
    public TwitterNotification(CamelContext camelContext) {
        this.camelContext = camelContext;

    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Usli smo u twitter processor! ");

        String tweet = "MR3 preps!" + counter.getAndIncrement();

        exchange.getOut().setBody(tweet);


    }
}
