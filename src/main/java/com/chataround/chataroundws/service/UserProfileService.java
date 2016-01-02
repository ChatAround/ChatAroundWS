package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.model.entity.UserProfile;
import com.chataround.chataroundws.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gewrgia
 */
@Service
public class UserProfileService implements IUserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    IMapper<UserProfile,UserProfileDTO> userProfileMapper;

    @Override
    public String createUserProfile(UserProfileDTO dto) {
        if(userProfileRepository.exists(dto.getUsername())) return "Already exists";
        userProfileRepository.saveAndFlush(userProfileMapper.fromDTO(dto));
        return "OK";
    }

    @Override
    public String updateUserProfile(UserProfileDTO dto) {
        if(!userProfileRepository.exists(dto.getUsername())) return "No such User";
        userProfileRepository.save(userProfileMapper.fromDTO(dto));
        return "OK";
    }

    @Override
    public UserProfileDTO getUserProfile(String username) {
        if(!userProfileRepository.exists(username)) return null;
        return userProfileMapper.toDTO(userProfileRepository.findOne(username));
    }

    @Override
    public String deleteUserProfile(String username) {
        if(!userProfileRepository.exists(username)) return "No such Profile";
        userProfileRepository.delete(username);
        return "OK";
    }
}
