package com.workflow2015.notification;

import com.workflow2015.notification.impl.TwitterNotification;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by emirk on 13/05/2015.
 */
@Component
public class NotificationRouteBuilder extends RouteBuilder {

    private String twitterEndpoint = "twitter://timeline/user";

    /*@Value("${a.token}") String token;
    @Value("${a.tokenSecret}") String tokenSecret;
    @Value("${c.key}") String consumerKey;
    @Value("${c.secret}") String keySecret;*/

    @Autowired
    TwitterNotification twitterNotification;
    @Override
    public void configure() throws Exception {

        from("file://test1/output")
                .routeId("twitterROUTEid").log("*************IDEMO NA MARS***************")
                .process(twitterNotification)
                .to(twitterEndpoint)
                .log("--------Finished posting on twitter ------- ")
                .end();

    }
}
