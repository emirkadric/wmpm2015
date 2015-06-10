package com.workflow2015.common;

import com.google.gson.annotations.Expose;
import com.workflow2015.common.citybike.CityBikeStation;
import com.workflow2015.common.directions.DirectionsDTO;
import com.workflow2015.common.openweathermap.OpenWeather;
import com.workflow2015.common.wienerlinien.Wienerlinien;
import org.apache.camel.Exchange;

import javax.annotation.Generated;
import java.util.List;

/**
 * Created by kumar on 23/05/15.
 */

@Generated("org.jsonschema2pojo")
public class DecisionMaker {
    
    @Expose
    CityBikeStation nearestCitybikeStation;
    @Expose
    DirectionsDTO directions;
    @Expose
    Wienerlinien subway;
    @Expose
    OpenWeather weather;

    public DecisionMaker decide(List<Exchange> exchanges)
    {
        for(Exchange e : exchanges)
        {
            Object body = e.getIn().getBody();
            if(body instanceof OpenWeather)
                weather = (OpenWeather) body;
            else if(body instanceof CityBikeStation)
                nearestCitybikeStation = (CityBikeStation) body;
            else if(body instanceof Wienerlinien)
                subway = (Wienerlinien) body;
            else if(body instanceof DirectionsDTO)
                directions = (DirectionsDTO) body;
            else
                new RuntimeException("Unknown type:" + body);
        }

        //todo make decision
        return this;

    }
}
