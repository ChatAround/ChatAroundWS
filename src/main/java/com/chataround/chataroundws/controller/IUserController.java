package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserController {
    ResponseEntity<List<UserDTO>> getAllUsers();
    void loginUser(UserDTO dto);
}
