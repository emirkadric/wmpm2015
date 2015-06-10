package com.workflow2015.common.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Mode implements Serializable {

    @Expose
    private String name;
    @Expose
    private String number;
    @Expose
    private String type;
    @Expose
    private String code;
    @Expose
    private String destination;
    @Expose
    private String destID;
    @Expose
    private String desc;
    @Expose
    private Diva diva;

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
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination The destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return The destID
     */
    public String getDestID() {
        return destID;
    }

    /**
     * @param destID The destID
     */
    public void setDestID(String destID) {
        this.destID = destID;
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
     * @return The diva
     */
    public Diva getDiva() {
        return diva;
    }

    /**
     * @param diva The diva
     */
    public void setDiva(Diva diva) {
        this.diva = diva;
    }

}
