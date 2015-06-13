package com.workflow2015.notification.impl;

import com.workflow2015.common.wlnews.Poi;
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

    @Autowired
    public TwitterNotification(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Usli smo u twitter processor! ");

        Poi disruption = exchange.getIn().getBody(Poi.class);
        String tweet = disruption.getAttributes().getLocation().toString()+"\nStatus: "
                        +disruption.getAttributes().getStatus().toString()+"\nFrom: "
                        +disruption.getAttributes().getAusVon().toString()+"\nTo: "
                        +disruption.getAttributes().getAusBis().toString();

        checkTweet(tweet); //140 char limit by twitter

        exchange.getOut().setBody(tweet);

    }
    private String checkTweet(String tweet)
    {
        if(tweet.length() >= 140)
            return tweet.substring(0, 140);
        else
            return tweet;
    }
}
