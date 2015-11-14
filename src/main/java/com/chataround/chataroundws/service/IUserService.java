package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;

import java.util.List;

/**
 * Created by Gewrgia on 10/11/2015.
 */
public interface IUserService {
    List<User> getAll();
}
