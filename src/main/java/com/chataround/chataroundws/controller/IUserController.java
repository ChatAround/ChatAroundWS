package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;
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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<UserDTO>> getUsersInRadius(@RequestParam("id") Long id, @RequestParam("radius") Double radius);

    ResponseEntity<Long> createUser(UserDTO dto, Model model);
    ResponseEntity<String> deleteUser(Long id);
    ResponseEntity<String> updateUser(UserDTO dto, Model model);

}
