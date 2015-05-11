package com.workflow2015.common.helper;

/**
 * Created by Dominik Heigl on 5/11/15.
 */
public class RouteRequest {
    private Integer time;
    private Coordinate from;
    private Coordinate to;

    private Coordinate toCoordinate(String coordinateString) {
        String[] coordinates = coordinateString.split(":");
        return new Coordinate(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Coordinate getFrom() {
        return from;
    }

    public void setFrom(Coordinate from) {
        this.from = from;
    }

    public Coordinate getTo() {
        return to;
    }

    public void setTo(Coordinate to) {
        this.to = to;
    }
}
