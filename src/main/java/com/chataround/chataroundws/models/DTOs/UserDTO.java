package com.chataround.chataroundws.models.DTOs;

import com.chataround.chataroundws.models.entities.Coordinates;

import java.io.Serializable;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public class UserDTO implements Serializable {
    private Long userId;
    private String username;
    private Coordinates coordinates;

    public UserDTO(){}

    public UserDTO(Long userId, String username, Coordinates coordinates) {
        this.userId = userId;
        this.username = username;
        this.coordinates = coordinates;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
