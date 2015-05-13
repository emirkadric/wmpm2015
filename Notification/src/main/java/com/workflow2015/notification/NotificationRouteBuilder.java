package com.workflow2015.notification;

import com.workflow2015.notification.impl.TwitterNotification;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by emirk on 13/05/2015.
 */
@Component
public class NotificationRouteBuilder extends RouteBuilder {

    private String twitterEndpoint = "twitter://timeline/user?consumerKey=ocTXdIPgczC4V3FDyDX5zG48t&consumerSecret=r0WCagiwtnfcIb2O6DuwCi0Shd6KzHQgVonQS2xKw8gMetgTKR&accessToken=75753355-pqX0uFbKLn8aGwSID6aT2WKXGUX5n9IPoCxtdrxgc&accessTokenSecret=il0H6hUmDeQzNn4fPf04mKBF4p7XrWp6IIWizA2wcIQ6U";

    @Autowired
    TwitterNotification twitterNotification;
    @Override
    public void configure() throws Exception {

        from("timer:tmr?period=5s")
                .routeId("twitterROUTEid").log("*************IDEMO NA MARS***************")
                .process(twitterNotification)
                .to(twitterEndpoint)
                .log("--------Finished posting on twitter ------- ")
                .end();

    }
}
