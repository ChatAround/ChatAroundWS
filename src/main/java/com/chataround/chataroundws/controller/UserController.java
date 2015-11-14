package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gewrgia on 10/11/2015.
 */
@RestController
public class UserController implements IUserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @Autowired
    IMapper<User, UserDTO> userMapper;

    @Override
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userMapper.toDTO(userService.getAll());

        return ResponseEntity
                .ok(userDTOs);
    }
}
