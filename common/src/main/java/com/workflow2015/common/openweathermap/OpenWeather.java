
package com.workflow2015.common.openweathermap;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;

@Generated("org.jsonschema2pojo")
public class OpenWeather implements Serializable {

    @Expose
    private String cod;
    @Expose
    private Double message;
    @Expose
    private City city;
    @Expose
    private Integer cnt;
    @Expose
    private java.util.List<List> list = new ArrayList<List>();

    /**
     * @return The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return The message
     */
    public Double getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     * @return The city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return The cnt
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     * @param cnt The cnt
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     * @return The list
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

}
