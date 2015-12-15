package com.chataround.chataroundws.model.DTO;


/**
 * @author Georgia Grigoriadou
 */
public class UserDTO {
    private Long id;
    private String username;
    private Double latitude;
    private Double longitude;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, Double latitude, Double longitude) {
        this.id = id;
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

