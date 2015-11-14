package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public interface IUserController {
    ResponseEntity<List<UserDTO>> getAllUsers();
}
