package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Frequency implements Serializable {

    @Expose
    private String hasFrequency;
    @Expose
    private String tripIndex;
    @Expose
    private String minTimeGap;
    @Expose
    private String maxTimeGap;
    @Expose
    private String avTimeGap;
    @Expose
    private String minDuration;
    @Expose
    private String maxDuration;
    @Expose
    private String avDuration;
    @Expose
    private List<Object> modes = new ArrayList<Object>();

    /**
     * @return The hasFrequency
     */
    public String getHasFrequency() {
        return hasFrequency;
    }

    /**
     * @param hasFrequency The hasFrequency
     */
    public void setHasFrequency(String hasFrequency) {
        this.hasFrequency = hasFrequency;
    }

    /**
     * @return The tripIndex
     */
    public String getTripIndex() {
        return tripIndex;
    }

    /**
     * @param tripIndex The tripIndex
     */
    public void setTripIndex(String tripIndex) {
        this.tripIndex = tripIndex;
    }

    /**
     * @return The minTimeGap
     */
    public String getMinTimeGap() {
        return minTimeGap;
    }

    /**
     * @param minTimeGap The minTimeGap
     */
    public void setMinTimeGap(String minTimeGap) {
        this.minTimeGap = minTimeGap;
    }

    /**
     * @return The maxTimeGap
     */
    public String getMaxTimeGap() {
        return maxTimeGap;
    }

    /**
     * @param maxTimeGap The maxTimeGap
     */
    public void setMaxTimeGap(String maxTimeGap) {
        this.maxTimeGap = maxTimeGap;
    }

    /**
     * @return The avTimeGap
     */
    public String getAvTimeGap() {
        return avTimeGap;
    }

    /**
     * @param avTimeGap The avTimeGap
     */
    public void setAvTimeGap(String avTimeGap) {
        this.avTimeGap = avTimeGap;
    }

    /**
     * @return The minDuration
     */
    public String getMinDuration() {
        return minDuration;
    }

    /**
     * @param minDuration The minDuration
     */
    public void setMinDuration(String minDuration) {
        this.minDuration = minDuration;
    }

    /**
     * @return The maxDuration
     */
    public String getMaxDuration() {
        return maxDuration;
    }

    /**
     * @param maxDuration The maxDuration
     */
    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    /**
     * @return The avDuration
     */
    public String getAvDuration() {
        return avDuration;
    }

    /**
     * @param avDuration The avDuration
     */
    public void setAvDuration(String avDuration) {
        this.avDuration = avDuration;
    }

    /**
     * @return The modes
     */
    public List<Object> getModes() {
        return modes;
    }

    /**
     * @param modes The modes
     */
    public void setModes(List<Object> modes) {
        this.modes = modes;
    }

}
