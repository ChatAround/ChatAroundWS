package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.model.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gewrgia
 */
@Component
public class UserProfileMapper implements IMapper<UserProfile,UserProfileDTO>{
    @Override
    public UserProfile fromDTO(UserProfileDTO dto) {
        UserProfile userProfile=new UserProfile(
                dto.getUsername(),
                dto.getFirstName(),
                dto.getSurName(),
                dto.getGender(),
                dto.getCountry(),
                dto.getCity(),
                dto.getBirthday(),
                dto.getAbout()
        );
        return userProfile;
    }

    @Override
    public List<UserProfile> fromDTO(List<UserProfileDTO> DTOs) {
        List<UserProfile> userProfiles= new ArrayList<>();

        for (UserProfileDTO dto :DTOs){
            userProfiles.add(fromDTO(dto));
        }
        return userProfiles;    }

    @Override
    public UserProfileDTO toDTO(UserProfile model) {
        UserProfileDTO dto=new UserProfileDTO(
                model.getUsername(),
                model.getFirstName(),
                model.getSurName(),
                model.getGender(),
                model.getCountry(),
                model.getCity(),
                model.getBirthday(),
                model.getAbout()

        );
        return dto;
    }

    @Override
    public List<UserProfileDTO> toDTO(List<UserProfile> models) {
        List<UserProfileDTO> userProfileDTOs = new ArrayList<>();

        for (UserProfile userProfile : models) {
            userProfileDTOs.add(toDTO(userProfile));
        }

        return userProfileDTOs;    }
}
