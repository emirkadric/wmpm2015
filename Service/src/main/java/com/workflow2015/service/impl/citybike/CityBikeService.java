package com.workflow2015.service.impl.citybike;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.IService;
//import com.workflow2015.service.helper.openweathermap.OpenWeather;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Component
public class CityBikeService implements Processor, IService<Object, String> {

    private static final Logger log = LoggerFactory.getLogger(CityBikeService.class);

    private final CamelContext camelContext;
    private final ProducerTemplate producerTemplate;

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public ProducerTemplate getProducerTemplate() {
        return producerTemplate;
    }

    @Autowired
    public CityBikeService(CamelContext camelContext, ProducerTemplate producerTemplate) {
        this.camelContext = camelContext;
        this.producerTemplate = producerTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String json = exchange.getIn().getBody(String.class);
        RouteRequest routeRequest = JsonHelper.gson.fromJson(json, RouteRequest.class);
        String data = this.getDataFromSource(routeRequest);
        this.pushDataToQueue(data);
    }

    @Override
    public String getDataFromSource(RouteRequest routeRequest) {
        String json = null;
        try {
            //TODO dynamic URL
            Exchange exchange = this.getProducerTemplate().request(
                    "http://data.wien.gv.at/daten/geo?service=WFS&request=GetFeature&version=1.1.0&typeName=ogdwien:CITYBIKEOGD&srsName=EPSG:4326&outputFormat=json"
                    , new Processor() {
                        public void process(Exchange exchange) throws Exception {
                        }
                    });

            if (null != exchange) {
                json = exchange.getOut().getBody(String.class);
//                OpenWeather openWeather = JsonHelper.gson.fromJson(json, OpenWeather.class);
                log.debug(json);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return json;
    }

    @Override
    public Object validateDataFetched(String data) {
        return null;
    }

    @Override
    public Object pushDataToQueue(String data) {
        this.getProducerTemplate().sendBody("activemq:topic:routerequest.result", data);
        return null;
    }
}
