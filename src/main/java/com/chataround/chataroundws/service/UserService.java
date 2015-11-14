package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
