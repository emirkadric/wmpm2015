package com.workflow2015.service.impl;

import org.apache.camel.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dominik Heigl on 5/6/15.
 */
@org.springframework.stereotype.Component
public class ServiceApplication {

    private final CamelContext camelContext;

    @Autowired
    public ServiceApplication(CamelContext camelContext) {
        this.camelContext = camelContext;
    }


    public void test() {
        try {
            ProducerTemplate template = this.camelContext.createProducerTemplate();
            this.camelContext.start();

            Exchange exchange = template.request("http://www.google.com/search", new Processor() {
                public void process(Exchange exchange) throws Exception {
                }
            });

            if (null != exchange) {
                Message out = exchange.getOut();
                int responseCode = out.getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);
                System.out.println("Response: " + String.valueOf(responseCode));
            }

            Thread.sleep(1000 * 3);
            this.camelContext.stop();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        System.out.println("DONE!!");
        /*RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
        System.out.println("Name:    " + page.getName());
        System.out.println("About:   " + page.getAbout());
        System.out.println("Phone:   " + page.getPhone());
        System.out.println("Website: " + page.getWebsite());*/
    }
}
