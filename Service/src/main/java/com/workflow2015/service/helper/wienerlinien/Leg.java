package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Leg implements Serializable {

    @Expose
    private List<Point> points = new ArrayList<Point>();
    @Expose
    private Mode mode;
    @Expose
    private Frequency frequency;
    @Expose
    private String path;
    @Expose
    private List<TurnInst> turnInst = new ArrayList<TurnInst>();
    @Expose
    private List<StopSeq> stopSeq = new ArrayList<StopSeq>();
    @Expose
    private Interchange interchange;

    /**
     * @return The points
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * @param points The points
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * @return The mode
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * @param mode The mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /**
     * @return The frequency
     */
    public Frequency getFrequency() {
        return frequency;
    }

    /**
     * @param frequency The frequency
     */
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    /**
     * @return The path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return The turnInst
     */
    public List<TurnInst> getTurnInst() {
        return turnInst;
    }

    /**
     * @param turnInst The turnInst
     */
    public void setTurnInst(List<TurnInst> turnInst) {
        this.turnInst = turnInst;
    }

    /**
     * @return The stopSeq
     */
    public List<StopSeq> getStopSeq() {
        return stopSeq;
    }

    /**
     * @param stopSeq The stopSeq
     */
    public void setStopSeq(List<StopSeq> stopSeq) {
        this.stopSeq = stopSeq;
    }

    /**
     * @return The interchange
     */
    public Interchange getInterchange() {
        return interchange;
    }

    /**
     * @param interchange The interchange
     */
    public void setInterchange(Interchange interchange) {
        this.interchange = interchange;
    }

}
