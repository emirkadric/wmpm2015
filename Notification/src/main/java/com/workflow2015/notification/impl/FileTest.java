package com.workflow2015.notification.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by emirk on 09/05/2015.
 */
@org.springframework.stereotype.Component
public class FileTest {

    private final CamelContext camelContext;

    @Autowired
    public FileTest(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public void testMe()
    {
        try {
            camelContext.addRoutes(new RouteBuilder() {

                @Override
                public void configure() throws Exception {
                    from("file:test1/inbox?noop=true")
                            .to("file:test1/output");
                    System.out.println("izvrshio kopiranje fajlova!");
                }
            });
            Thread.sleep(1000 * 3);
            camelContext.stop();
        }catch (Exception e)
        {
            System.out.println("Greska: "+e.getMessage());
        }

    }
}
