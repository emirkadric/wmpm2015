package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class WLnews implements Serializable {

    @Expose
    private Data data;

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}

