package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserController {
    ResponseEntity<List<UserDTO>> getAllUsers();
    ResponseEntity<Long> createUser(UserDTO dto, Model model);
    ResponseEntity<String> logoutUser(Long id);
    ResponseEntity<String> updateUser(UserDTO dto, Model model);

}
