package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Location implements Serializable{

    @Expose
    private String type;
    @Expose
    private Properties properties;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     *
     * @param properties
     * The properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
