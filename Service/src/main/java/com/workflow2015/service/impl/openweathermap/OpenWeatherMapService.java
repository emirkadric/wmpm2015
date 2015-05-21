package com.workflow2015.service.impl.openweathermap;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.IService;
import com.workflow2015.service.helper.openweathermap.OpenWeather;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dominik Heigl on 5/6/15.
 */
@org.springframework.stereotype.Component
public class OpenWeatherMapService implements Processor, IService<OpenWeather, String> {

    private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapService.class);

    private final CamelContext camelContext;
    private final ProducerTemplate producerTemplate;

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public ProducerTemplate getProducerTemplate() {
        return producerTemplate;
    }

    //Example to read values from config file
    /*@Value("${openweathermap.url}")
    String url;*/

    @Autowired
    public OpenWeatherMapService(CamelContext camelContext, ProducerTemplate producerTemplate) {
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
                    "http://api.openweathermap.org/data/2.5/forecast?lat=" +
                            routeRequest.getFrom().getLatitude() + "&lon=" +
                            routeRequest.getFrom().getLongitude() +
                            "&units=metric"
                    , new Processor() {
                        public void process(Exchange exchange) throws Exception {
                        }
                    });

            if (null != exchange) {
                json = exchange.getOut().getBody(String.class);
                OpenWeather openWeather = JsonHelper.gson.fromJson(json, OpenWeather.class);
                log.debug(json);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return json;
    }

    @Override
    public OpenWeather validateDataFetched(String data) {
        return null;
    }

    @Override
    public OpenWeather pushDataToQueue(String data) {
        this.getProducerTemplate().sendBody("activemq:topic:routerequest.result", data);
        return null;
    }
}
