package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.User;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gewrgia on 14/11/2015.
 */
@Component
public class UserMapper implements IMapper<User, UserDTO> {
    @Override
    public User fromDTO(UserDTO dto) {
        throw new NotImplementedException();
    }

    @Override
    public List<User> fromDTO(List<UserDTO> DTOs) {
        throw new NotImplementedException();
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getCoordinates()
        );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTO(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            userDTOs.add(toDTO(user));
        }

        return userDTOs;
    }
}
