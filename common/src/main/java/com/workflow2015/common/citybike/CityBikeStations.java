package com.workflow2015.common.citybike;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by kumar on 21/05/15.
 */


public class CityBikeStations implements Serializable {

    private List<CityBikeStation> bikes;
    private TreeMap<String, CityBikeStation> bikeTree;

    public List<CityBikeStation> getBikes() {
        return bikes;
    }

    public void setBikes(List<CityBikeStation> bikes) {
        this.bikes = bikes;
    }

    public CityBikeStations(List<CityBikeStation> bikes) {
        this.bikes = bikes;
        bikeTree = new TreeMap<>();
        for (CityBikeStation bike : bikes) {
            bikeTree.put(new LngLat(bike.getLng(), bike.getLat()).toString(), bike);

        }
    }

    public CityBikeStation getClosestBikeStation(double lng, double lat) {
        //todo ugly conversion
        //parameteres come as Double 48.19911; we need long 48199110

        long longlng = (long) (lng * 1000000);
        long longlat = (long) (lat * 1000000);

        LngLat position = new LngLat(longlng, longlat);

        String nearestPos = bikeTree.ceilingKey(position.toString());

        return bikeTree.get(nearestPos);

    }

    @Override
    public String toString() {
        return String.format("Citybikestations [%s]", size());

    }

    public int size() {
        return bikes.size();
    }
}
