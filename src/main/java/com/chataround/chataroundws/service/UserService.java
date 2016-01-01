package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.UserDTO;
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
       if(!userRepository.exists(username)) return null;
        User user=userRepository.findOne(username);
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
    public String deleteUser(String username)  {
        if( !userRepository.exists(username)) return "No such User";
        userRepository.delete(username);
        return "OK";
    }

    @Override
    public String updateUser(UserDTO dto){

        if( !userRepository.exists(dto.getUsername())) return "No such User";
        if(!userRepository.findOne(dto.getUsername()).getPassword().equals(dto.getPassword())) return "Wrong Password";
        userRepository.save(userMapper.fromDTO(dto));
        return "OK";
    }

    @Override
    public UserDTO getUser(String username){
        if( !userRepository.exists(username)) return null;
        return userMapper.toDTO(userRepository.findOne(username));
    }
}
