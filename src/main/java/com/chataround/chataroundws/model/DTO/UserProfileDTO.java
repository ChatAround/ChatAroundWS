package com.chataround.chataroundws.model.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Gewrgia
 */
public class UserProfileDTO {
    @NotNull
    private String username;
    @NotNull
    @Size (min=4,max=16)
    private String firstName;
    @NotNull
    @Size (min=4,max=16)
    private String surName;
    @NotNull
    private String gender;
    @Size (max=16)
    private String country;
    @Size (max=16)
    private String city;
    @NotNull
    private Date birthday;
    @Size (max=2000)
    private String about;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String username, String firstName,
                          String surName, String gender,String country, String city,
                          Date birthday, String about) {
        this.username = username;
        this.firstName = firstName;
        this.surName = surName;
        this.gender=gender;
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
