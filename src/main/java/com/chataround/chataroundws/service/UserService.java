package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
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

    @Autowired
    IMapper<User,UserDTO> userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDTO(userRepository.findAll());
    }

    @Override
    public UserDTO addUser(UserDTO dto){
        User added=userMapper.fromDTO(dto);
        userRepository.saveAndFlush(added);
        return userMapper.toDTO(added);
    }
}
