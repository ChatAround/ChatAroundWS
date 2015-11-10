package com.chataround.chataroundws.services;

import com.chataround.chataroundws.models.DTOs.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public interface IUserService {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<Collection<UserDTO>> getAllUsers();
}
