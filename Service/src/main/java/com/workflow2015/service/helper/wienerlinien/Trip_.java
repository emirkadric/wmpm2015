package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Trip_ implements Serializable {

    @Expose
    private String duration;
    @Expose
    private String interchange;
    @Expose
    private String desc;
    @Expose
    private List<Leg> legs = new ArrayList<Leg>();
    @Expose
    private List<Object> attrs = new ArrayList<Object>();

    /**
     * @return The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return The interchange
     */
    public String getInterchange() {
        return interchange;
    }

    /**
     * @param interchange The interchange
     */
    public void setInterchange(String interchange) {
        this.interchange = interchange;
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
     * @return The legs
     */
    public List<Leg> getLegs() {
        return legs;
    }

    /**
     * @param legs The legs
     */
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
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

}
