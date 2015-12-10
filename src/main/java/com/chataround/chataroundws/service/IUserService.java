package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IUserService {
    List<UserDTO> getAll();

    List<UserDTO> getInRadius(Long id, Double radius);

    UserDTO addUser(UserDTO dto);
    String deleteUser(Long id);
    String update(UserDTO dto);
}
