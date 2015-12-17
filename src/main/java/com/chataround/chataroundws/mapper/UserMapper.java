package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.Coordinates;
import com.chataround.chataroundws.model.entity.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgia Grigoriadou
 */

@Component
public class UserMapper implements IMapper<User, UserDTO> {
    @Override
    public User fromDTO(UserDTO dto) {
        Coordinates coordinates=new Coordinates(dto.getLatitude(),dto.getLongitude());
        User user=new User(
                dto.getUsername(),
                coordinates
        );
        return user;

    }

    @Override
    public List<User> fromDTO(List<UserDTO> DTOs) {
        List<User> users= new ArrayList<>();

        for (UserDTO dto :DTOs){
            users.add(fromDTO(dto));
        }
        return users;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getUsername(),
                user.getCoordinates().getLatitude(),
                user.getCoordinates().getLongitude()
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
