package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserService {
    List<UserDTO> getAll();

    List<UserDTO> getInRadius(Long id, Double radius);

    Long addUser(UserDTO dto);
    void deleteUser(Long id);
    void update(UserDTO dto);
}
