package com.workflow2015.common.helper;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class From implements Serializable {

    @Expose
    @NotNull
    private Double latitude;
    @Expose
    @NotNull
    private Double longitude;

    /**
     * @return The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", Double.toString(latitude), Double.toString(longitude));
    }
}
