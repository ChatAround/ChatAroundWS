package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.exception.NullLocationPropertiesException;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value="/user",method = RequestMethod.POST )
    public ResponseEntity<Long> createUser(UserDTO dto, Model model) {
        if(dto.getLongitude()==null || dto.getLongitude()==null) throw new NullLocationPropertiesException();
            return ResponseEntity.ok(userService.addUser(dto).getId());

    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.DELETE )
    public ResponseEntity<String> deleteUser(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.PUT )
    public ResponseEntity<String> updateUser(UserDTO dto, Model model) {
        return ResponseEntity.ok(userService.update(dto));
    }


}
