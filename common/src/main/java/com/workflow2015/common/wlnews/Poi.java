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
public class Poi implements Serializable{

    @Expose
    private Integer refPoiCategoryId;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String name;
    @Expose
    private Attributes attributes;
    @Expose
    private Integer id;
    @Expose
    private String teaser;
    @Expose
    private List<String> names = new ArrayList<String>();
    @Expose
    private Location location;
    @Expose
    private Long start;
    @Expose
    private Long end;

    /**
     *
     * @return
     * The refPoiCategoryId
     */
    public Integer getRefPoiCategoryId() {
        return refPoiCategoryId;
    }

    /**
     *
     * @param refPoiCategoryId
     * The refPoiCategoryId
     */
    public void setRefPoiCategoryId(Integer refPoiCategoryId) {
        this.refPoiCategoryId = refPoiCategoryId;
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
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     *
     * @return
     * The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     *
     * @param attributes
     * The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

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
     * The teaser
     */
    public String getTeaser() {
        return teaser;
    }

    /**
     *
     * @param teaser
     * The teaser
     */
    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    /**
     *
     * @return
     * The names
     */
    public List<String> getNames() {
        return names;
    }

    /**
     *
     * @param names
     * The names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The start
     */
    public Long getStart() {
        return start;
    }

    /**
     *
     * @param start
     * The start
     */
    public void setStart(Long start) {
        this.start = start;
    }

    /**
     *
     * @return
     * The end
     */
    public Long getEnd() {
        return end;
    }

    /**
     *
     * @param end
     * The end
     */
    public void setEnd(Long end) {
        this.end = end;
    }

}
