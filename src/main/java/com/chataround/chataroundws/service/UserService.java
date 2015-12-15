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
    public List<UserDTO> getInRadius(Long id,Double radius) {
        User user=getUserById(id);
        return userMapper.toDTO(userRepository.findInRadius(
                user.getCoordinates().getLatitude(),
                user.getCoordinates().getLongitude(),
                radius));
    }

    @Override
    public Long addUser(UserDTO dto){
        User added=userMapper.fromDTO(dto);
        userRepository.saveAndFlush(added);
        return added.getId();
    }

    @Override
    public void deleteUser(Long id)  {

        userRepository.delete(id);
    }
    @Override
    public void update(UserDTO dto){

        User user = userRepository.findOne(userMapper.fromDTO(dto).getId());
        Coordinates coordinates= new Coordinates(dto.getLatitude(),dto.getLongitude());

        user.setUsername(dto.getUsername());
        user.setCoordinates(coordinates);

        userRepository.saveAndFlush(user);
    }

    public User getUserById(Long id){
        return userRepository.findOne(id);
    }
}
