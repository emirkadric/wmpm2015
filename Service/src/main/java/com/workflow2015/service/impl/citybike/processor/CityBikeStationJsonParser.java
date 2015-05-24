package com.workflow2015.service.impl.citybike.processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.workflow2015.common.helper.JsonHelper;
import com.workflow2015.service.helper.citybike.CityBikeStation;
import com.workflow2015.service.helper.citybike.CityBikeStations;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kumar on 23/05/15.
 */
@Component
public class CityBikeStationJsonParser implements Processor {

    private Gson gson;
    private Type collectionType;

    public CityBikeStationJsonParser()
    {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        collectionType = new TypeToken<List<CityBikeStation>>() {}.getType();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String json = exchange.getIn().getBody().toString();
        CityBikeStations stations = new CityBikeStations(gson.fromJson(json, collectionType));
        exchange.getIn().setBody(stations);
    }
}
