package com.workflow2015.common.directions;

import java.io.Serializable;

/**
 * Created by kumar on 10/06/15.
 */
public class DirectionsStepDTO implements Serializable {
    private String distance;
    private String duration;
    private String directionHTML;


    public DirectionsStepDTO(String duration, String distance,String directionHTML) {
        this.duration = duration;
        this.distance = distance;
        this.directionHTML = directionHTML;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
