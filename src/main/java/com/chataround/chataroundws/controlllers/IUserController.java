package com.chataround.chataroundws.controlllers;

import com.chataround.chataroundws.models.DTOs.UserDTO;
import com.chataround.chataroundws.models.entities.User;

import java.util.Collection;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public interface IUserController {

    UserDTO createDTO(User user);

    Collection<UserDTO> createDTOs(Collection<User> users);

    Collection<UserDTO> getAllUsersDTOs();
}