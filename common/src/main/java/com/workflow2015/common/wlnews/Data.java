package com.workflow2015.common.wlnews;

/**
 * Created by emirk on 13/06/2015.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Data implements Serializable{

    @Expose
    private List<Poi> pois = new ArrayList<Poi>();
    @Expose
    private List<PoiCategory> poiCategories = new ArrayList<PoiCategory>();
    @Expose
    private List<PoiCategoryGroup> poiCategoryGroups = new ArrayList<PoiCategoryGroup>();

    /**
     *
     * @return
     * The pois
     */
    public List<Poi> getPois() {
        return pois;
    }

    /**
     *
     * @param pois
     * The pois
     */
    public void setPois(List<Poi> pois) {
        this.pois = pois;
    }

    /**
     *
     * @return
     * The poiCategories
     */
    public List<PoiCategory> getPoiCategories() {
        return poiCategories;
    }

    /**
     *
     * @param poiCategories
     * The poiCategories
     */
    public void setPoiCategories(List<PoiCategory> poiCategories) {
        this.poiCategories = poiCategories;
    }

    /**
     *
     * @return
     * The poiCategoryGroups
     */
    public List<PoiCategoryGroup> getPoiCategoryGroups() {
        return poiCategoryGroups;
    }

    /**
     *
     * @param poiCategoryGroups
     * The poiCategoryGroups
     */
    public void setPoiCategoryGroups(List<PoiCategoryGroup> poiCategoryGroups) {
        this.poiCategoryGroups = poiCategoryGroups;
    }

}