package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserController {
    ResponseEntity<List<UserDTO>> getAllUsers();
}
