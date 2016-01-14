package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserController {

    ResponseEntity<List<UserDTO>> getUsersInRadius( String username,  Double radius);

    ResponseEntity<?> createUser(UserDTO dto, Model model);
    ResponseEntity<?> deleteUser(String username);

    ResponseEntity<?> updateUser(String username, String password, Double latitude, Double longitude, boolean isOnline);

    ResponseEntity<UserDTO> getUser(String username);
}
