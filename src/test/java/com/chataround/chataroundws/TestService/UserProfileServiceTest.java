package com.chataround.chataroundws.TestService;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.model.entity.UserProfile;
import com.chataround.chataroundws.repository.UserProfileRepository;
import com.chataround.chataroundws.service.UserProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Gewrgia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserProfileServiceTest {


    private MockMvc mockMvc;

    @InjectMocks
    private UserProfileService userProfileService;

    @Mock
    private UserProfileRepository userProfileRepository;
    @Mock
    private IMapper<UserProfile,UserProfileDTO> userProfileMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userProfileService).build();

    }

    @Test
    public void testCreateUserProfileSuccess() throws Exception{
        String username="test";
        String firstName="Test";
        String surName="Tester";
        String gender="male";
        String country="Greece";
        String city="Serres";
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        String about= "mplampla";

        UserProfile userProfile=new UserProfile(username,firstName,surName,gender,
                country,city,birthday,about);
        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,gender,
                country,city,birthday,about);

        Mockito.when(userProfileRepository.exists(username)).thenReturn(false);
        Mockito.when(userProfileMapper.fromDTO(dto)).thenReturn(userProfile);

        String response=userProfileService.createUserProfile(dto);
        assertEquals(response,"OK");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).saveAndFlush(Mockito.any(UserProfile.class));
        Mockito.reset(userProfileRepository);

    }

    @Test
    public void testCreateUserProfileFail() throws Exception{
        String username="test";
        String firstName="Test";
        String surName="Tester";
        String gender="male";
        String country="Greece";
        String city="Serres";
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        String about= "mplampla";

        UserProfile userProfile=new UserProfile(username,firstName,surName,gender,
                country,city,birthday,about);
        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,gender,
                country,city,birthday,about);

        Mockito.when(userProfileRepository.exists(username)).thenReturn(true);
        Mockito.when(userProfileMapper.fromDTO(dto)).thenReturn(userProfile);

        String response=userProfileService.createUserProfile(dto);
        assertEquals(response,"Already exists");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(0)).saveAndFlush(Mockito.any(UserProfile.class));
        Mockito.reset(userProfileRepository);

    }

    @Test
    public void testUpdateUserProfileSuccess() throws Exception{
        String username="test";
        String firstName="Test";
        String surName="Tester";
        String gender="male";
        String country="Greece";
        String city="Serres";
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        String about= "mplamplaa";

        UserProfile userProfile=new UserProfile(username,firstName,surName,gender,
                country,city,birthday,about);
        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,gender,
                country,city,birthday,about);

        Mockito.when(userProfileRepository.exists(username)).thenReturn(true);
        Mockito.when(userProfileMapper.fromDTO(dto)).thenReturn(userProfile);

        String response=userProfileService.updateUserProfile(dto);
        assertEquals(response,"OK");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).save(Mockito.any(UserProfile.class));
        Mockito.reset(userProfileRepository);

    }

    @Test
    public void testUpdateUserProfileFail() throws Exception{
        String username="test";
        String firstName="Test";
        String surName="Tester";
        String gender="male";
        String country="Greece";
        String city="Serres";
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        String about= "mplampla";

        UserProfile userProfile=new UserProfile(username,firstName,surName,gender,
                country,city,birthday,about);
        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,gender,
                country,city,birthday,about);

        Mockito.when(userProfileRepository.exists(username)).thenReturn(false);
        Mockito.when(userProfileMapper.fromDTO(dto)).thenReturn(userProfile);

        String response=userProfileService.updateUserProfile(dto);
        assertEquals(response,"No such User");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(0)).save(Mockito.any(UserProfile.class));
        Mockito.reset(userProfileRepository);

    }

    @Test
    public void testGetUserProfileSuccess() throws Exception{
        String username="test";
        String firstName="Test";
        String surName="Tester";
        String gender="male";
        String country="Greece";
        String city="Serres";
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        String about= "mplampla";

        UserProfile userProfile=new UserProfile(username,firstName,surName,gender,
                country,city,birthday,about);
        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,gender,
                country,city,birthday,about);

        Mockito.when(userProfileRepository.exists(username)).thenReturn(true);
        Mockito.when(userProfileRepository.findOne(username)).thenReturn(userProfile);
        Mockito.when(userProfileMapper.toDTO(userProfile)).thenReturn(dto);

        UserProfileDTO response=userProfileService.getUserProfile(username);
        assertEquals(response.getUsername(),username);
        assertEquals(response.getFirstName(),firstName);
        assertEquals(response.getSurName(),surName);
        assertEquals(response.getCountry(),country);
        assertEquals(response.getCity(),city);
        assertEquals(response.getGender(),gender);
        assertEquals(response.getBirthday(),birthday);
        assertEquals(response.getAbout(),about);

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.reset(userProfileRepository);
    }

    @Test
    public void testGetUserProfileFail() throws Exception{
        String username="test";

        Mockito.when(userProfileRepository.exists(username)).thenReturn(false);

        UserProfileDTO response=userProfileService.getUserProfile(username);
        assertEquals(response,null);

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(0)).findOne(Mockito.anyString());
        Mockito.reset(userProfileRepository);
    }

    @Test
    public void testDeleteUserProfileSuccess() throws Exception{
        String username="test";

        Mockito.when(userProfileRepository.exists(username)).thenReturn(true);

        String response=userProfileService.deleteUserProfile(username);
        assertEquals(response,"OK");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).delete(Mockito.anyString());
        Mockito.reset(userProfileRepository);
    }
    @Test
    public void testDeleteUserProfileFail() throws Exception{
        String username="test";

        Mockito.when(userProfileRepository.exists(username)).thenReturn(false);

        String response=userProfileService.deleteUserProfile(username);
        assertEquals(response,"No such Profile");

        Mockito.verify(userProfileRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userProfileRepository, VerificationModeFactory.times(0)).delete(Mockito.anyString());
        Mockito.reset(userProfileRepository);
    }


}
