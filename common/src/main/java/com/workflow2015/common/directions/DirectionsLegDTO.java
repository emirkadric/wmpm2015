package com.workflow2015.common.directions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar on 10/06/15.
 */
public class DirectionsLegDTO implements Serializable {
    private List<DirectionsStepDTO> waypoints;
    private String distance;
    private String duration;

    public DirectionsLegDTO(String distance, String duration) {
        this.distance = distance;
        this.duration = duration;
    }

    public void addStep(DirectionsStepDTO step)
    {
        if(waypoints==null)
            waypoints = new ArrayList<>();
        waypoints.add(step);

    }

    public DirectionsLegDTO() {
    }

    public List<DirectionsStepDTO> getWaypoints() {
        return waypoints;
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
