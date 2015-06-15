package com.workflow2015.notification;


import com.workflow2015.notification.impl.EmailAdvertising;
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

    @Autowired
    EmailAdvertising emailAdvertising;

    @Override
    public void configure() throws Exception {

        from("activemq:topic:disruption")
                .routeId("twitterROUTEid").log("*************Twitter***************")
                .doTry()
                    .process(twitterNotification)
                    .to(twitterEndpoint)
                .doCatch(Exception.class).to("activemq:twitterErrors")
                .end();

        from("jpa://User?consumer.query=select o from User o where o.subscribed=true&consumeDelete=false&consumer.delay=604800000")
                .routeId("subscriberCollection").log("***********Fetching of subscribers started************")
                .log("CamelBatchSize (property) = ${property.CamelBatchSize}")
                .log("CamelBatchSize (header)   = ${header.CamelBatchSize}")
                .to("activemq:topic:subscribers").log("**********Fetching of subscribers ended!")
                .end();

        from("activemq:topic:subscribers")
                .routeId("email adverts").log("+++++++++++++Email advertising started!+++++++++++++")
                .process(emailAdvertising)
                .to("velocity:file:../notification/src/main/resources/emailTemplate.vm?encoding=utf8")
                .to("smtps://smtp.gmail.com:465?username=workflowss2015@gmail.com&password=workflow").log("Sending of email finished.")
                .end();

    }
}
