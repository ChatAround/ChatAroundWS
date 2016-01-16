package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.service.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Gewrgia
 */
@RestController
public class UserProfileController implements IUserProfileController {

    @Autowired
    IUserProfileService userProfileService;


    @Override
    @RequestMapping(value = "/userProfile", method = RequestMethod.POST)
    public ResponseEntity<?> createUserProfile(@Valid UserProfileDTO dto, Model model) {
        userProfileService.createUserProfile(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @Override
    @RequestMapping(value = "/userProfile", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserProfile(
            @RequestParam("username") String username,
            @RequestParam("firstName") String firstName,
            @RequestParam("surName") String surName,
            @RequestParam("gender") String gender,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("birthday") Date birthday,
            @RequestParam("about") String about) {
        UserProfileDTO dto=new UserProfileDTO(
          username,firstName,surName,gender,country,city,birthday,about
        );
        userProfileService.updateUserProfile(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public ResponseEntity<UserProfileDTO> getUserProfile(@RequestParam("username") String username){

    return ResponseEntity.ok(userProfileService.getUserProfile(username));
        }

    @Override
    @RequestMapping(value = "/userProfile", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserProfile(@RequestParam("username") String username) {

        userProfileService.deleteUserProfile(username);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
