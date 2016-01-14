package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.Date;

/**
 * @author Gewrgia
 */
public interface IUserProfileController {


    ResponseEntity<?> createUserProfile(UserProfileDTO dto, Model model);


    ResponseEntity<?> updateUserProfile(String username, String firstName, String surName, String gender, String country, String city, Date birthday, String about);

    ResponseEntity<UserProfileDTO> getUserProfile(String username);

    ResponseEntity<?> deleteUserProfile(String username);
}
