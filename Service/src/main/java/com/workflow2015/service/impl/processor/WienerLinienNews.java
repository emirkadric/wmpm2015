package com.workflow2015.service.impl.processor;

import com.workflow2015.common.wlnews.WLnews;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by emirk on 13/06/2015.
 */
@Component
public class WienerLinienNews implements Processor {

    private final CamelContext camelContext;

    @Autowired
    public WienerLinienNews(CamelContext camelContext) {this.camelContext = camelContext;}

    private String uriBuilder()
    {
        return "restlet:http://www.wienerlinien.at/ogd_realtime/newsList?sender=EK1aM0NgnB";
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        WLnews request = exchange.getIn().getBody(WLnews.class);
        exchange.getIn().setHeader("newslisturi", this.uriBuilder());
        exchange.getIn().setBody(request, WLnews.class);

    }
}
