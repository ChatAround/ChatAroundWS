package com.chataround.chataroundws.services;

import com.chataround.chataroundws.controlllers.IUserController;
import com.chataround.chataroundws.models.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Gewrgia on 10/11/2015.
 */
@RestController
public class UserService implements IUserService{
   @Autowired
    IUserController userController;

    @Override
    public ResponseEntity<Collection<UserDTO>> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Collection<UserDTO> userDTOs = null;

        headers.add("Content-Type", "application/json;charset=UTF-8");

        try {
            userDTOs = userController.getAllUsersDTOs();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(userDTOs, headers, status);
    }
}
