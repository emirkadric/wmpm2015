package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Trip implements Serializable {

    @Expose
    private Trip_ trip;

    /**
     * @return The trip
     */
    public Trip_ getTrip() {
        return trip;
    }

    /**
     * @param trip The trip
     */
    public void setTrip(Trip_ trip) {
        this.trip = trip;
    }

}
