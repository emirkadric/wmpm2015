package com.workflow2015.service.impl.citybike;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.common.helper.RouteRequest;
import com.workflow2015.service.IService;
import com.workflow2015.service.helper.citybike.CityBikeStations;
import com.workflow2015.service.helper.citybike.CityBikeStation;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;


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
                    //"http://data.wien.gv.at/daten/geo?service=WFS&request=GetFeature&version=1.1.0&typeName=ogdwien:CITYBIKEOGD&srsName=EPSG:4326&outputFormat=json"
                    "http://api.citybik.es/citybike-wien.json"
                    , new Processor() {
                        public void process(Exchange exchange) throws Exception {
                        }
                    });

            if (null != exchange) {
                json = exchange.getOut().getBody(String.class);

                //todo dirty: make gson singleton
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
                Type collectionType = new TypeToken<List<CityBikeStation>>(){}.getType();
                CityBikeStations stations = new CityBikeStations(gson.fromJson(json, collectionType));
                log.debug(String.format("loaded %s citybikes",stations.size()));

                CityBikeStation nearestStation = stations.getClosestBikeStation(routeRequest.getFrom().getLongitude(),routeRequest.getFrom().getLatitude());
                log.debug(String.format("closest citybike station: %s", nearestStation ==null ? nearestStation : "")) ;
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ex.getMessage();
        }

        return json.subSequence(0,json.length()%200).toString();//dont spam the debug log
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
