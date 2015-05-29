package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class StopSeq implements Serializable {

    @Expose
    private String name;
    @Expose
    private String nameWO;
    @Expose
    private String place;
    @Expose
    private String nameWithPlace;
    @Expose
    private String omc;
    @Expose
    private String placeID;
    @Expose
    private String platformName;
    @Expose
    private Ref_ ref;

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
     * @return The nameWO
     */
    public String getNameWO() {
        return nameWO;
    }

    /**
     * @param nameWO The nameWO
     */
    public void setNameWO(String nameWO) {
        this.nameWO = nameWO;
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
     * @return The platformName
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * @param platformName The platformName
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**
     * @return The ref
     */
    public Ref_ getRef() {
        return ref;
    }

    /**
     * @param ref The ref
     */
    public void setRef(Ref_ ref) {
        this.ref = ref;
    }

}
