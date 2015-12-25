package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserService {
    List<UserDTO> getAll();


    List<UserDTO> getInRadius(String username, Double radius);

    String addUser(UserDTO dto);
    void deleteUser(String username);

    String updateUser(UserDTO dto);

    UserDTO getUser(String username);
}
