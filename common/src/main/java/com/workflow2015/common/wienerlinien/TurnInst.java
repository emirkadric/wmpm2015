package com.workflow2015.common.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class TurnInst implements Serializable {

    @Expose
    private String dir;
    @Expose
    private String manoeuvre;
    @Expose
    private String name;
    @Expose
    private String dirHint;
    @Expose
    private String place;
    @Expose
    private String tTime;
    @Expose
    private String ctTime;
    @Expose
    private String dis;
    @Expose
    private String cDis;
    @Expose
    private String coords;

    /**
     * @return The dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir The dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return The manoeuvre
     */
    public String getManoeuvre() {
        return manoeuvre;
    }

    /**
     * @param manoeuvre The manoeuvre
     */
    public void setManoeuvre(String manoeuvre) {
        this.manoeuvre = manoeuvre;
    }

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
     * @return The dirHint
     */
    public String getDirHint() {
        return dirHint;
    }

    /**
     * @param dirHint The dirHint
     */
    public void setDirHint(String dirHint) {
        this.dirHint = dirHint;
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
     * @return The tTime
     */
    public String getTTime() {
        return tTime;
    }

    /**
     * @param tTime The tTime
     */
    public void setTTime(String tTime) {
        this.tTime = tTime;
    }

    /**
     * @return The ctTime
     */
    public String getCtTime() {
        return ctTime;
    }

    /**
     * @param ctTime The ctTime
     */
    public void setCtTime(String ctTime) {
        this.ctTime = ctTime;
    }

    /**
     * @return The dis
     */
    public String getDis() {
        return dis;
    }

    /**
     * @param dis The dis
     */
    public void setDis(String dis) {
        this.dis = dis;
    }

    /**
     * @return The cDis
     */
    public String getCDis() {
        return cDis;
    }

    /**
     * @param cDis The cDis
     */
    public void setCDis(String cDis) {
        this.cDis = cDis;
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

}
