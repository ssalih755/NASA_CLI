package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Neo {

    private String id;
    private String name;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAstroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    @Override
    public String toString() {
        return "Neo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isPotentiallyHazardousAstroid=" + isPotentiallyHazardousAsteroid +
                ", estimatedDiameter=" + estimatedDiameter +
                '}';
    }
}
