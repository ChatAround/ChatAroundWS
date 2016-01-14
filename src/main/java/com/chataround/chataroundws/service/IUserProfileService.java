package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;

/**
 * @author Gewrgia
 */
public interface IUserProfileService {
    void createUserProfile(UserProfileDTO dto);

    void updateUserProfile(UserProfileDTO dto);

    UserProfileDTO getUserProfile(String username);

    void deleteUserProfile(String username);
}
