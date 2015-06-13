package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Properties implements Serializable {

    @Expose
    private String type;
    @Expose
    private String coordName;

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
     * The coordName
     */
    public String getCoordName() {
        return coordName;
    }

    /**
     *
     * @param coordName
     * The coordName
     */
    public void setCoordName(String coordName) {
        this.coordName = coordName;
    }

}