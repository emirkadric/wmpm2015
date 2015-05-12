package com.workflow2015.service.impl.openweathermap;

import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.IService;
import com.workflow2015.service.helper.openweathermap.OpenWeather;
import org.apache.camel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominik Heigl on 5/6/15.
 */
@org.springframework.stereotype.Component
public class OpenWeatherMap implements Processor, IService<Object, String> {

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
    public OpenWeatherMap(CamelContext camelContext, ProducerTemplate producerTemplate) {
        this.camelContext = camelContext;
        this.producerTemplate = producerTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("TEST");
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
                Message out = exchange.getOut();
                int responseCode = out.getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);
                System.out.println("Response: " + String.valueOf(responseCode));
                json = exchange.getOut().getBody(String.class);
                OpenWeather openWeather = JsonHelper.gson.fromJson(json, OpenWeather.class);
                System.out.println(json);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return json;
    }

    @Override
    public Object validateDataFetched(String data) {
        return null;
    }

    @Override
    public Object pushDataToQueue(String data) {
        Map<String, Object> header = new HashMap<>();
        header.put("rabbitmq.ROUTING_KEY", "routerequestresult");

        this.getProducerTemplate().sendBodyAndHeaders("rabbitmq://localhost/bptexchange?exchangeType=topic&queue=bptoutgoing", data, header);
        return null;
    }
}
