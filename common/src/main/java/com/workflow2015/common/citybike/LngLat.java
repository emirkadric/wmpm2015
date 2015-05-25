package com.workflow2015.common.citybike;

import java.io.Serializable;

/**
 * Created by kumar on 21/05/15.
 */
public class LngLat implements Comparable<LngLat>,Serializable {

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
