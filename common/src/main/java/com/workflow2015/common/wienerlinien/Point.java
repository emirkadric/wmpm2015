package com.workflow2015.common.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Point implements Serializable {

    @Expose
    private String name;
    @Expose
    private String place;
    @Expose
    private String nameWithPlace;
    @Expose
    private String usage;
    @Expose
    private String omc;
    @Expose
    private String placeID;
    @Expose
    private String desc;
    @Expose
    private DateTime dateTime;
    @Expose
    private Stamp stamp;
    @Expose
    private List<Link> links = new ArrayList<Link>();
    @Expose
    private Ref ref;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place The place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return The nameWithPlace
     */
    public String getNameWithPlace() {
        return nameWithPlace;
    }

    /**
     * @param nameWithPlace The nameWithPlace
     */
    public void setNameWithPlace(String nameWithPlace) {
        this.nameWithPlace = nameWithPlace;
    }

    /**
     * @return The usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * @param usage The usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * @return The omc
     */
    public String getOmc() {
        return omc;
    }

    /**
     * @param omc The omc
     */
    public void setOmc(String omc) {
        this.omc = omc;
    }

    /**
     * @return The placeID
     */
    public String getPlaceID() {
        return placeID;
    }

    /**
     * @param placeID The placeID
     */
    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    /**
     * @return The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return The dateTime
     */
    public DateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime The dateTime
     */
    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return The stamp
     */
    public Stamp getStamp() {
        return stamp;
    }

    /**
     * @param stamp The stamp
     */
    public void setStamp(Stamp stamp) {
        this.stamp = stamp;
    }

    /**
     * @return The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * @return The ref
     */
    public Ref getRef() {
        return ref;
    }

    /**
     * @param ref The ref
     */
    public void setRef(Ref ref) {
        this.ref = ref;
    }

}
