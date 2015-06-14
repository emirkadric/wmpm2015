package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class PoiCategory implements Serializable{

    @Expose
    private Integer id;
    @Expose
    private Integer refPoiCategoryGroupId;
    @Expose
    private String title;
    @Expose
    private String name;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The refPoiCategoryGroupId
     */
    public Integer getRefPoiCategoryGroupId() {
        return refPoiCategoryGroupId;
    }

    /**
     *
     * @param refPoiCategoryGroupId
     * The refPoiCategoryGroupId
     */
    public void setRefPoiCategoryGroupId(Integer refPoiCategoryGroupId) {
        this.refPoiCategoryGroupId = refPoiCategoryGroupId;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

}