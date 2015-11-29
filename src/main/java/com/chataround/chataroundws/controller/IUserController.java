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
   ResponseEntity<UserDTO> createUser(UserDTO dto, Model model);

}
