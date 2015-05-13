package com.workflow2015.notification.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.twitter.TwitterComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

/**
 * Created by emirk on 13/05/2015.
 */
@Component
public class TwitterNotification implements Processor {
    private final CamelContext camelContext;
    /*@Value("${a.token}") String token;
    @Value("${a.tokenSecret}") String tokenSecret;
    @Value("${c.key}") String consumerKey;
    @Value("${c.secret}") String keySecret;*/

    @Autowired
    public TwitterNotification(CamelContext camelContext)
    {
        this.camelContext = camelContext;

    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Usli smo u twitter processor! ");

        TwitterComponent twitter = camelContext.getComponent("twitter", TwitterComponent.class);
        twitter.setAccessToken("75753355-pqX0uFbKLn8aGwSID6aT2WKXGUX5n9IPoCxtdrxgc");
        twitter.setAccessTokenSecret("75753355-pqX0uFbKLn8aGwSID6aT2WKXGUX5n9IPoCxtdrxgc");
        twitter.setConsumerKey("7C9B7x83kDHKeq1llCq6wzWYG");
        twitter.setConsumerSecret("EbLyy6YHIkrm0OnW50MyXTLW3mqzJBsAYpYTPAcwdYTBq1pqSM");

        String tweet = "Hello/Hallo/Pozdrav WMPM 2015 IR1";

        exchange.getOut().setBody(tweet);

    }
}
