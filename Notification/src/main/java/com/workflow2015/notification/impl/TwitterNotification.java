package com.workflow2015.notification.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.twitter.TwitterComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by emirk on 13/05/2015.
 */
@Component
public class TwitterNotification implements Processor {
    private final CamelContext camelContext;

    @Autowired
    public TwitterNotification(CamelContext camelContext)
    {
        this.camelContext = camelContext;

    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Usli smo u twitter processor! ");

        String tweet = "Hello/Hallo/Pozdrav WMPM 2015 IR1";

        exchange.getOut().setBody(tweet);


    }
}
