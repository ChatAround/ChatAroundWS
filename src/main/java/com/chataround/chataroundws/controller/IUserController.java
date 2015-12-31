package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserController {

    ResponseEntity<List<UserDTO>> getUsersInRadius( String username,  Double radius);

    ResponseEntity<String> createUser(UserDTO dto, Model model);
    ResponseEntity<String> deleteUser(String username);

    ResponseEntity<String> updateUser(String username,  String password, Double latitude,  Double longitude, boolean isOnline);

    ResponseEntity<UserDTO> getUser(String username);
}
