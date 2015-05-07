package com.workflow2015.common;

import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/7/15.
 */
@Component
public class RouteBuilder extends org.apache.camel.builder.RouteBuilder {
    @Override
    public void configure() throws Exception {
        System.out.println("\n" +
                "\n" +
                "\ntestalskdjfasdlökfj\n\n\n");
        /*from("http4:get:graph.facebook.com/pivotalsoftware").
                transform().body();*/
    }
}
