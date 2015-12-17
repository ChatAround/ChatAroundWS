package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.Coordinates;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserDTO> getInRadius(String username, Double radius) {
        User user=getUserById(username);
        return userMapper.toDTO(userRepository.findInRadius(
                user.getCoordinates().getLatitude(),
                user.getCoordinates().getLongitude(),
                radius));
    }

    @Override
    public String addUser(UserDTO dto){
        if(userRepository.findOne(dto.getUsername())!=null) return "Already exists";
        User added=userMapper.fromDTO(dto);
        userRepository.saveAndFlush(added);
        return "OK";
    }

    @Override
    public void deleteUser(String username)  {

        userRepository.delete(username);
    }

    public User getUserById(String username){
        return userRepository.findOne(username);
    }
}
