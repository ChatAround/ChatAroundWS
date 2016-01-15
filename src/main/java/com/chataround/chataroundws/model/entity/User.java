package com.chataround.chataroundws.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Georgia Grigoriadou
 */


@Entity
@Table(name = "user_table")
public class User {
    @Id
    @NotNull
    @Size(min=4, max = 16)
    private String username;

    @NotNull
    @Size(min=4, max = 16)
    private String password;

    @NotNull
    @Embedded
    private Coordinates coordinates;

    private boolean isOnline;

    public User() {
    }

    public User(String username,String password, Coordinates coordinates, boolean isOnline) {
        this.username = username;
        this.password=password;
        this.coordinates = coordinates;
        this.isOnline=isOnline;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }


}
