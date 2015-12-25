package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author Gewrgia
 */
public interface IUserProfileService {
    String createUserProfile(UserProfileDTO dto);

    String updateUserProfile(UserProfileDTO dto);

    UserProfileDTO getUserProfile(String username);

    String deleteUserProfile(String username);
}
