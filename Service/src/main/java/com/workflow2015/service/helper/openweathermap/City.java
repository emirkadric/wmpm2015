package com.workflow2015.service.helper.openweathermap;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class City implements Serializable {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private Coord coord;
    @Expose
    private String country;
    @Expose
    private Integer population;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return The coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * @param coord The coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * @param population The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

}
