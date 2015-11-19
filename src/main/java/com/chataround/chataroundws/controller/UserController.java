package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.entity.LogIn;
import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@RestController
public class UserController implements IUserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    IUserService userService;



    @Override
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAll();

        return ResponseEntity
                .ok(userDTOs);
    }

    @Override
    @RequestMapping(value = "/login")
    @SendTo("/topic/chat")
    public LogIn loginUser(UserDTO userDTO){
        userService.addUser(userDTO);
        return new LogIn( userDTO.getUsername() + "  logged in");

    }
}
