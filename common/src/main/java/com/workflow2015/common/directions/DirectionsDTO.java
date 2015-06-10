package com.workflow2015.common.directions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar on 10/06/15.
 */
public class DirectionsDTO implements Serializable {
    private List<DirectionsLegDTO> legs;
    private String distance;
    private String duration;

    public DirectionsDTO(String duration, String distance) {
        this.duration = duration;
        this.distance = distance;
    }

    public DirectionsDTO() {
    }

    public void addLeg(DirectionsLegDTO leg)
    {
        if(legs==null)
            legs = new ArrayList<>();
        legs.add(leg);
    }

    public List<DirectionsLegDTO> getLegs() {
        return legs;
    }

    public void setLegs(List<DirectionsLegDTO> legs) {
        this.legs = legs;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
