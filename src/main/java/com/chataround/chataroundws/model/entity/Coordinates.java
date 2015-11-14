package com.chataround.chataroundws.model.entity;

import javax.persistence.Embeddable;
import org.springframework.data.geo.Point;

/**
 * @author Georgia Grigoriadou
 */
@Embeddable
public class Coordinates {
    private Double latitude;
    private Double longitude;

    public Coordinates() {
    }

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates(Point coordinates) {
        this.latitude = coordinates.getX();
        this.longitude = coordinates.getY();
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

    public Point getCoordinates() {
        return new Point(latitude, longitude);
    }

    public void setCoordinates(Point coordinates) {
        this.latitude = coordinates.getX();
        this.longitude = coordinates.getY();
    }
}