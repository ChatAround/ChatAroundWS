package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.exception.NullLocationPropertiesException;
import com.chataround.chataroundws.service.IUserService;
import com.chataround.chataroundws.model.DTO.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<UserDTO>> getUsersInRadius(@RequestParam("username") String username,@RequestParam("radius") Double radius) {
        if(radius==null) return ResponseEntity.ok(userService.getAll());
        return ResponseEntity.ok(userService.getInRadius(username,radius));
    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.POST )
    public ResponseEntity<String> createUser(UserDTO dto, Model model) {
        if(dto.getLatitude()==null || dto.getLongitude()==null) throw new NullLocationPropertiesException();
            return ResponseEntity.ok(userService.addUser(dto));

    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.DELETE )
    public ResponseEntity<String> deleteUser(@RequestParam("username") String username) {
        return ResponseEntity.ok(userService.deleteUser(username));

    }

    @Override
    @RequestMapping(value="/user",method = RequestMethod.PUT )
    public ResponseEntity<String> updateUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("isOnline") boolean isOnline) {
        if(latitude==null || longitude==null) throw new NullLocationPropertiesException();



        UserDTO dto=new UserDTO(
                username,
                password,
                latitude,longitude,
                isOnline
        );
        return ResponseEntity.ok(userService.updateUser(dto));
    }




    @Override
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@RequestParam("username") String username){
        return ResponseEntity.ok(userService.getUser(username));
    }



}
