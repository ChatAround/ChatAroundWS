package com.chataround.chataroundws.model.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author Georgia Grigoriadou
 */
@Embeddable
public class Coordinates {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    public Coordinates() {
    }

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


}