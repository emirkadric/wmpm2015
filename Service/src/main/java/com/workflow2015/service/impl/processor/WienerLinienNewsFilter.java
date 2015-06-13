package com.workflow2015.service.impl.processor;

import com.workflow2015.common.wlnews.WLnews;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by emirk on 13/06/2015.
 */
@Component
public class WienerLinienNewsFilter implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        WLnews allNewsItems = exchange.getIn().getBody(WLnews.class);

        exchange.getIn().setBody(allNewsItems.getData().getPois().get(0));

    }
}
