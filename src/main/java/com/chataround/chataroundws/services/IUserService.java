package com.chataround.chataroundws.services;

import com.chataround.chataroundws.models.DTOs.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public interface IUserService {

    public ResponseEntity<Collection<UserDTO>> getAllUsers();
}
