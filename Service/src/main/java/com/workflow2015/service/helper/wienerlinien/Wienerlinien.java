package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Wienerlinien implements Serializable {

    @Expose
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @Expose
    private List<Trip> trips = new ArrayList<Trip>();

    /**
     * @return The parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * @param parameters The parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * @return The trips
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * @param trips The trips
     */
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

}
