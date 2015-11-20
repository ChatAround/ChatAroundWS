package com.chataround.chataroundws.model.DTO;

import com.chataround.chataroundws.model.entity.Coordinates;

/**
 * @author Georgia Grigoriadou
 */
public class UserDTO {
    private Long id;
    private String username;
    private Double latitude;
    private Double logitude;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, Double latitude, Double logitude) {
        this.id = id;
        this.username = username;
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLogitude() {
        return logitude;
    }

    public void setLogitude(Double logitude) {
        this.logitude = logitude;
    }
}

