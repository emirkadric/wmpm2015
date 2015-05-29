package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Ref_ implements Serializable {

    @Expose
    private String id;
    @Expose
    private String area;
    @Expose
    private String platform;
    @Expose
    private String NaPTANID;
    @Expose
    private List<Object> attrs = new ArrayList<Object>();
    @Expose
    private String coords;
    @Expose
    private String arrDateTime;
    @Expose
    private String depDateTime;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area The area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return The platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform The platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return The NaPTANID
     */
    public String getNaPTANID() {
        return NaPTANID;
    }

    /**
     * @param NaPTANID The NaPTANID
     */
    public void setNaPTANID(String NaPTANID) {
        this.NaPTANID = NaPTANID;
    }

    /**
     * @return The attrs
     */
    public List<Object> getAttrs() {
        return attrs;
    }

    /**
     * @param attrs The attrs
     */
    public void setAttrs(List<Object> attrs) {
        this.attrs = attrs;
    }

    /**
     * @return The coords
     */
    public String getCoords() {
        return coords;
    }

    /**
     * @param coords The coords
     */
    public void setCoords(String coords) {
        this.coords = coords;
    }

    /**
     * @return The arrDateTime
     */
    public String getArrDateTime() {
        return arrDateTime;
    }

    /**
     * @param arrDateTime The arrDateTime
     */
    public void setArrDateTime(String arrDateTime) {
        this.arrDateTime = arrDateTime;
    }

    /**
     * @return The depDateTime
     */
    public String getDepDateTime() {
        return depDateTime;
    }

    /**
     * @param depDateTime The depDateTime
     */
    public void setDepDateTime(String depDateTime) {
        this.depDateTime = depDateTime;
    }

}
