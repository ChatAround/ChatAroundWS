package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserService {
    List<UserDTO> getAll();


    List<UserDTO> getInRadius(String username, Double radius);

    void addUser(UserDTO dto);
    void deleteUser(String username);

    void updateUser(UserDTO dto);

    UserDTO getUser(String username);
}
