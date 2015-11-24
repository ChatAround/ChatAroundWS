package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.repository.UserRepository;
import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Controller
public class UserController implements IUserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    IUserService userService;

@Autowired
    UserRepository repository;



    @Override
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAll();

        return ResponseEntity
                .ok(userDTOs);
    }

    @Override
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public void loginUser(@RequestParam UserDTO dto) {
        userService.addUser(dto);
    }


}
