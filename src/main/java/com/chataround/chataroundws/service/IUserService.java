package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserService {
    List<UserDTO> getAll();


    List<UserDTO> getInRadius(String username, Double radius);

    String addUser(UserDTO dto);
    void deleteUser(String username);
}
