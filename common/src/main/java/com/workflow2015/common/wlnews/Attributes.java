package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Attributes implements Serializable{

    @Expose
    private List<String> relatedLines = new ArrayList<String>();
    @Expose
    private List<Integer> relatedStops = new ArrayList<Integer>();
    @Expose
    private String location;
    @Expose
    private String station;
    @Expose
    private String status;
    @Expose
    private List<Integer> rbls = new ArrayList<Integer>();
    @Expose
    private String ausVon;
    @Expose
    private String ausBis;
    @Expose
    private String towards;

    /**
     *
     * @return
     * The relatedLines
     */
    public List<String> getRelatedLines() {
        return relatedLines;
    }

    /**
     *
     * @param relatedLines
     * The relatedLines
     */
    public void setRelatedLines(List<String> relatedLines) {
        this.relatedLines = relatedLines;
    }

    /**
     *
     * @return
     * The relatedStops
     */
    public List<Integer> getRelatedStops() {
        return relatedStops;
    }

    /**
     *
     * @param relatedStops
     * The relatedStops
     */
    public void setRelatedStops(List<Integer> relatedStops) {
        this.relatedStops = relatedStops;
    }

    /**
     *
     * @return
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The station
     */
    public String getStation() {
        return station;
    }

    /**
     *
     * @param station
     * The station
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The rbls
     */
    public List<Integer> getRbls() {
        return rbls;
    }

    /**
     *
     * @param rbls
     * The rbls
     */
    public void setRbls(List<Integer> rbls) {
        this.rbls = rbls;
    }

    /**
     *
     * @return
     * The ausVon
     */
    public String getAusVon() {
        return ausVon;
    }

    /**
     *
     * @param ausVon
     * The ausVon
     */
    public void setAusVon(String ausVon) {
        this.ausVon = ausVon;
    }

    /**
     *
     * @return
     * The ausBis
     */
    public String getAusBis() {
        return ausBis;
    }

    /**
     *
     * @param ausBis
     * The ausBis
     */
    public void setAusBis(String ausBis) {
        this.ausBis = ausBis;
    }

    /**
     *
     * @return
     * The towards
     */
    public String getTowards() {
        return towards;
    }

    /**
     *
     * @param towards
     * The towards
     */
    public void setTowards(String towards) {
        this.towards = towards;
    }

}