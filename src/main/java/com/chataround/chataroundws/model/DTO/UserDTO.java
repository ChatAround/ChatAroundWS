package com.chataround.chataroundws.model.DTO;


import javax.validation.constraints.NotNull;

/**
 * @author Georgia Grigoriadou
 */
public class UserDTO {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    private boolean isOnline;
    public UserDTO() {
    }

    public UserDTO( String username,String password,Double latitude, Double longitude,boolean isOnline) {

        this.username = username;
        this.password=password;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isOnline=isOnline;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}

