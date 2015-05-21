package com.workflow2015.service.helper.citybike;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by kumar on 21/05/15.
 */
public class LngLat implements Comparable<LngLat> {

    private Long lng;
    private Long lat;
    public LngLat(Long lng, Long lat)
    {
        this.lng=lng;
        this.lat=lat;
    }

    @Override
    public String toString(){
        return String.format("%d:%d", lng,lat);
    }

    @Override
    public int compareTo(LngLat o) {
        return this.toString().compareTo(o.toString());
    }
}
