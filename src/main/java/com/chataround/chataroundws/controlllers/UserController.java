package com.chataround.chataroundws.controlllers;

import com.chataround.chataroundws.models.DTOs.UserDTO;
import com.chataround.chataroundws.models.entities.User;
import com.chataround.chataroundws.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gewrgia on 10/11/2015.
 */
@Controller
public class UserController implements IUserController{

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDTO createDTO(User user) {
        UserDTO userDTO=new UserDTO(
            user.getUserId(),
            user.getUsername(),
            user.getCoordinates());
        return userDTO;

    }

    @Override
    public Collection<UserDTO> createDTOs(Collection<User> users) {
        Collection<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            userDTOs.add(createDTO(user));
        }

        return userDTOs;
    }

    @Override
    public Collection<UserDTO> getAllUsersDTOs() {
        Collection<User> users = userRepository.findAll();
        return createDTOs(users);
    }
}
