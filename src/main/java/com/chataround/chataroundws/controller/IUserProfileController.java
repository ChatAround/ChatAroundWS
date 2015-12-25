package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author Gewrgia
 */
public interface IUserProfileController {


    ResponseEntity<String> createUserProfile(UserProfileDTO dto, Model model);


    ResponseEntity<String> updateUserProfile(String username,String firstName,String surName,String gender,String country,String city,Date birthday,String about);

    ResponseEntity<UserProfileDTO> getUserProfile(String username);

    ResponseEntity<String> deleteUserProfile(String username);
}
