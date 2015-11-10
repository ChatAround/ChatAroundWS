package com.chataround.chataroundws.models.entities;

import javax.persistence.*;

/**
 * Created by Gewrgia on 10/11/2015.
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name= "username")
    private String username;
    @AttributeOverrides({
            @AttributeOverride(name="latitude", column = @Column(name="latitude")),
            @AttributeOverride(name="longitude", column = @Column(name="longitude"))
    })
    private Coordinates coordinates;

    public User(){}

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
