package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class NeoFeedResponse {

    // Map where key is a date
    // value is an array we turn into a List
    @JsonProperty("near_earth_objects")
    private Map<String, List<Neo>> nearEarthObjects;

    public Map<String, List<Neo>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<String, List<Neo>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }

    @Override
    public String toString() {
        return "NeoFeedResponse{" +
                "nearEarthObjects=" + nearEarthObjects +
                '}';
    }
}
