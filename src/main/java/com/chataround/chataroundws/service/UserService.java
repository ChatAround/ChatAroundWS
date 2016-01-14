package com.chataround.chataroundws.service;

import com.chataround.chataroundws.exception.AlreadyInUseUsername;
import com.chataround.chataroundws.exception.OnlineUserNotFoundException;
import com.chataround.chataroundws.exception.WrongPasswordException;
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
       if(!userRepository.exists(username) || !userRepository.findOne(username).isOnline()) throw new OnlineUserNotFoundException();
        if(radius==null) return getAll();
        User user=userRepository.findOne(username);
        return userMapper.toDTO(userRepository.findInRadius(
                user.getCoordinates().getLatitude(),
                user.getCoordinates().getLongitude(),
                radius));
    }

    @Override
    public void addUser(UserDTO dto){
        if(userRepository.findOne(dto.getUsername())!=null) throw new AlreadyInUseUsername();
        User added=userMapper.fromDTO(dto);
        userRepository.saveAndFlush(added);

    }

    @Override
    public void deleteUser(String username)  {
        if( !userRepository.exists(username)|| !userRepository.findOne(username).isOnline()) throw new OnlineUserNotFoundException();
        userRepository.delete(username);
    }

    @Override
    public void updateUser(UserDTO dto){

        if( !userRepository.exists(dto.getUsername()) ) throw new OnlineUserNotFoundException();
        if(!userRepository.findOne(dto.getUsername()).getPassword().equals(dto.getPassword())) throw new WrongPasswordException();
        userRepository.save(userMapper.fromDTO(dto));
    }

    @Override
    public UserDTO getUser(String username){
        if( !userRepository.exists(username)) throw new OnlineUserNotFoundException();
        return userMapper.toDTO(userRepository.findOne(username));
    }
}
