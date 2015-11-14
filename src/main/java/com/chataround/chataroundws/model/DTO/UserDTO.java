package com.chataround.chataroundws.model.DTO;

import com.chataround.chataroundws.model.entity.Coordinates;

/**
 * @author Georgia Grigoriadou
 */
public class UserDTO {
    private Long id;
    private String username;
    private Coordinates coordinates;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, Coordinates coordinates) {
        this.id = id;
        this.username = username;
        this.coordinates = coordinates;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
