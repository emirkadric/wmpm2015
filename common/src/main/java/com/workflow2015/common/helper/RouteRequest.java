
package com.workflow2015.common.helper;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class RouteRequest implements Serializable {
    @Expose
    private Integer date;
    @Expose
    private Integer time;
    @Expose
    private From from;
    @Expose
    private To to;

    /**
     *
     * @return
     *     The date
     */
    public Integer getDate() {
        return date;
    }

    /**
     *
     * @param date
     *     The date
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * @return The time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * @return The from
     */
    public From getFrom() {
        return from;
    }

    /**
     * @param from The from
     */
    public void setFrom(From from) {
        this.from = from;
    }

    /**
     * @return The to
     */
    public To getTo() {
        return to;
    }

    /**
     * @param to The to
     */
    public void setTo(To to) {
        this.to = to;
    }

}
