package com.chataround.chataroundws.model.entity;

import javax.persistence.*;

/**
 * @author Georgia Grigoriadou
 */


@Entity
@Table(name = "user_table")
public class User {
    @Id
    private String username;

    @Embedded
    private Coordinates coordinates;

    public User() {
    }

    public User(String username, Coordinates coordinates) {
        this.username = username;
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
