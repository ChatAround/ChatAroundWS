package com.chataround.chataroundws.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Gewrgia
 */
@Entity
public class UserProfile {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String firstName;
    @NotNull
    private String surName;
    @NotNull
    private String gender;
    private String country;
    private String city;
    @javax.persistence.Temporal(TemporalType.DATE)
    private Date birthday;
    private String about;

    public UserProfile() {
    }

    public UserProfile(String username, String firstName,
                       String surName, String gender,String country, String city,
                       Date birthday, String about) {
        this.username = username;
        this.firstName = firstName;
        this.surName = surName;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.birthday = birthday;
        this.about = about;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
