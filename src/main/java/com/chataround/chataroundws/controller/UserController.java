package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<UserDTO>> getUsersInRadius(@RequestParam("username") String username,@RequestParam("radius") Double radius) {
        return ResponseEntity.ok(userService.getInRadius(username,radius));
    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.POST )
    public ResponseEntity<?> createUser(@Valid UserDTO dto, Model model) {
        userService.addUser(dto);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.DELETE )
    public ResponseEntity<?> deleteUser(@RequestParam("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.PUT )
    public ResponseEntity<?> updateUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("isOnline") boolean isOnline) {


        UserDTO dto=new UserDTO(
                username,
                password,
                latitude,longitude,
                isOnline
        );
        userService.updateUser(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }




    @Override
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@RequestParam("username") String username){
        return ResponseEntity.ok(userService.getUser(username));
    }



}
