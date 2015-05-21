package com.workflow2015.service.impl.wienerlinien;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.IService;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 5/21/15.
 */
@Component
public class WienerLinienService implements Processor, IService<Object, String> {
    private static final Logger log = LoggerFactory.getLogger(WienerLinienService.class);

    private final CamelContext camelContext;
    private final ProducerTemplate producerTemplate;
    private final XmlJsonDataFormat xmlJsonDataFormat;


    public CamelContext getCamelContext() {
        return camelContext;
    }

    public ProducerTemplate getProducerTemplate() {
        return producerTemplate;
    }

    @Autowired
    public WienerLinienService(CamelContext camelContext, ProducerTemplate producerTemplate) {
        this.camelContext = camelContext;
        this.producerTemplate = producerTemplate;
        this.xmlJsonDataFormat = new XmlJsonDataFormat();
    }


    @Override
    public String getDataFromSource(RouteRequest routeRequest) {
        String xml = null;
        try {
            //TODO dynamic URL
            Exchange exchange = this.getProducerTemplate().request(
                    "http://www.wienerlinien.at/ogd_routing/XML_TRIP_REQUEST2?loc%20ationServerActive=1&type_origin=any&name_origin=Westbahnhof&%20type_destination=any&name_destination=Stephansplatz"
                    , new Processor() {
                        public void process(Exchange exchange) throws Exception {
                        }
                    });

            if (null != exchange) {
//                xml = exchange.getOut().getBody(String.class);
                xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
                log.debug(xml);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return xml;
    }

    @Override
    public Object validateDataFetched(String data) {
        return null;
    }

    @Override
    public Object pushDataToQueue(String data) {
        this.getProducerTemplate().sendBody("activemq:topic:requestprocessing.wienerlinien", data);
        return null;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        //TODO
        Object header = exchange.getIn().getHeader("wienerlinien");

        if (header == null) {
            String json = exchange.getIn().getBody(String.class);
            RouteRequest routeRequest = JsonHelper.gson.fromJson(json, RouteRequest.class);
            String data = this.getDataFromSource(routeRequest);
            this.pushDataToQueue(data);
        } else if (header.equals("location")) {
            String json = exchange.getIn().getBody(String.class);
            log.debug(json);
        }


    }
}
