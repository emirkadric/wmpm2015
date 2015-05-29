package com.workflow2015.service.helper.openweathermap;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Sys implements Serializable {

    @Expose
    private String pod;

    /**
     * @return The pod
     */
    public String getPod() {
        return pod;
    }

    /**
     * @param pod The pod
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

}
