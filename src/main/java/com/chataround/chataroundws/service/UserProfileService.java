package com.chataround.chataroundws.service;

        import com.chataround.chataroundws.exception.AlreadyInUseUsername;
        import com.chataround.chataroundws.exception.OnlineUserNotFoundException;
        import com.chataround.chataroundws.mapper.IMapper;
        import com.chataround.chataroundws.model.DTO.UserProfileDTO;
        import com.chataround.chataroundws.model.entity.UserProfile;
        import com.chataround.chataroundws.repository.UserProfileRepository;
        import com.chataround.chataroundws.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUserProfile(UserProfileDTO dto) {
        if(!userRepository.exists(dto.getUsername())) throw new OnlineUserNotFoundException();
        if(userProfileRepository.exists(dto.getUsername())) throw new AlreadyInUseUsername();
        userProfileRepository.saveAndFlush(userProfileMapper.fromDTO(dto));

    }

    @Override
    public void updateUserProfile(UserProfileDTO dto) {
        if(!userProfileRepository.exists(dto.getUsername()) || !userRepository.findOne(dto.getUsername()).isOnline()) throw new OnlineUserNotFoundException();
        userProfileRepository.save(userProfileMapper.fromDTO(dto));
    }

    @Override
    public UserProfileDTO getUserProfile(String username) {
        if(!userProfileRepository.exists(username)|| !userRepository.findOne(username).isOnline()) throw new OnlineUserNotFoundException();
        return userProfileMapper.toDTO(userProfileRepository.findOne(username));
    }

    @Override
    public void deleteUserProfile(String username) {
        if(!userProfileRepository.exists(username)|| !userRepository.findOne(username).isOnline())throw new OnlineUserNotFoundException();
        userProfileRepository.delete(username);
    }
}
