package com.chataround.chataroundws.TestService;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.exception.UserNotFoundException;
import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.Coordinates;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.repository.UserRepository;
import com.chataround.chataroundws.service.UserService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Gewrgia
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserServiceTest {

private MockMvc mockMvc;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private IMapper<User,UserDTO> userMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();

    }
    @Test(expected = UserNotFoundException.class)
    public void testGetUserFail() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=40.123456;
        Double longitude=22.123456;
        Boolean isOnline=true;

        Coordinates coordinates=new Coordinates(latitude,longitude);
        User user = new User(
                username,
                password,
                coordinates,
                isOnline);
        UserDTO dto=new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);
        Mockito.when(userRepository.exists(username)).thenReturn(false);
        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.toDTO(user)).thenReturn(dto);

        UserDTO fromRepo = userService.getUser(username);


        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).findOne(Mockito.anyString());
        Mockito.reset(userRepository);
    }
    @Test
    public void testGetUserSuccess() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=40.123456;
        Double longitude=22.123456;
        Boolean isOnline=true;

        Coordinates coordinates=new Coordinates(latitude,longitude);
        User user = new User(
                username,
                password,
                coordinates,
                isOnline);
        UserDTO dto=new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);
        Mockito.when(userRepository.exists(username)).thenReturn(true);
        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.toDTO(user)).thenReturn(dto);

        UserDTO fromRepo = userService.getUser(username);

        assertEquals(username, fromRepo.getUsername());
        assertEquals(password,fromRepo.getPassword());
        assertEquals(latitude,fromRepo.getLatitude());
        assertEquals(longitude,fromRepo.getLongitude());
        assertEquals(isOnline,fromRepo.isOnline());

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.reset(userRepository);
    }


    @Test
    public void testAddUserSuccess() throws Exception{
        String username="test";
        String password="12345";
        Double latitude=40.123456;
        Double longitude=22.123456;
        Boolean isOnline=true;
        UserDTO dto=new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);

        Coordinates coordinates=new Coordinates(latitude,longitude);
        User user = new User(
                username,
                password,
                coordinates,
                isOnline);

        Mockito.when(userRepository.findOne(username)).thenReturn(null);
        Mockito.when(userMapper.fromDTO(dto)).thenReturn(user);

        String response=userService.addUser(dto);
        assertEquals(response,"OK");

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).saveAndFlush(Mockito.any(User.class));
        Mockito.reset(userRepository);

    }

    @Test
    public void testAddUserFail() throws Exception{
        String username="test";
        String password="12345";
        Double latitude=40.123456;
        Double longitude=22.123456;
        Boolean isOnline=true;
        UserDTO dto=new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);

        Coordinates coordinates=new Coordinates(latitude,longitude);
        User added = new User(
                username,
                password,
                coordinates,
                isOnline);
        User user = new User();
        user.setUsername(username);

        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.fromDTO(dto)).thenReturn(added);


        String response=userService.addUser(dto);
        assertEquals(response,"Already exists");

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).saveAndFlush(Mockito.any(User.class));

        Mockito.reset(userRepository);

    }

    @Test(expected = UserNotFoundException.class)
    public void testUpdateUserFailToFindUser() throws Exception {
        String username = "test";
        String password = "12345";
        Double latitude = 40.123456;
        Double longitude = 22.123456;
        Boolean isOnline = true;
        UserDTO dto = new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);

        Coordinates coordinates = new Coordinates(latitude, longitude);
        User user = new User(
                username,
                password,
                coordinates,
                isOnline);

        Mockito.when(userRepository.exists(dto.getUsername())).thenReturn(false);
        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.fromDTO(dto)).thenReturn(user);


        String response = userService.updateUser(dto);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));

        Mockito.reset(userRepository);
    }

    @Test
    public void testUpdateUserFailWrongPassword() throws Exception {
        String username = "test";
        String password = "12345";
        String password2 = "09876";
        Double latitude = 40.123456;
        Double longitude = 22.123456;
        Boolean isOnline = true;
        UserDTO dto = new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);


        Coordinates coordinates = new Coordinates(latitude, longitude);
        User user = new User(
                username,
                password2,
                coordinates,
                isOnline);

        User updated = new User(
                username,
                password,
                coordinates,
                isOnline);

        Mockito.when(userRepository.exists(dto.getUsername())).thenReturn(true);
        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.fromDTO(dto)).thenReturn(updated);


        String response = userService.updateUser(dto);
        assertEquals(response, "Wrong Password");

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).save(Mockito.any(User.class));

        Mockito.reset(userRepository);
    }


    @Test
    public void testUpdateUserSuccess() throws Exception {
        String username = "test";
        String password = "12345";
        Double latitude = 40.123456;
        Double longitude = 22.123456;
        Boolean isOnline = true;
        UserDTO dto = new UserDTO(username,
                password,
                latitude,
                longitude,
                isOnline);


        Coordinates coordinates = new Coordinates(latitude, longitude);
        Coordinates coordinates2 = new Coordinates(40.98265, 22.098375);

        User user = new User(
                username,
                password,
                coordinates2,
                isOnline);

        User updated = new User(
                username,
                password,
                coordinates,
                isOnline);

        Mockito.when(userRepository.exists(dto.getUsername())).thenReturn(true);
        Mockito.when(userRepository.findOne(username)).thenReturn(user);
        Mockito.when(userMapper.fromDTO(dto)).thenReturn(updated);


        String response = userService.updateUser(dto);
        assertEquals(response, "OK");

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).save(Mockito.any(User.class));

        Mockito.reset(userRepository);
    }

    @Test(expected = UserNotFoundException.class)
    public void testDeleteUserFail() throws Exception {
        String username="test";

        Mockito.when(userRepository.exists(username)).thenReturn(false);

        String response = userService.deleteUser(username);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).delete(Mockito.anyString());

        Mockito.reset(userRepository);
    }

    @Test
    public void testDeleteUserSuccess() throws Exception {
        String username="test";

        Mockito.when(userRepository.exists(username)).thenReturn(true);

        String response = userService.deleteUser(username);
        assertEquals(response, "OK");

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).delete(Mockito.anyString());

        Mockito.reset(userRepository);
    }


    @Test(expected = UserNotFoundException.class)
    public void testGetUsersInRadiusFailNoSuchUser() throws Exception{
        String username="test";
        Double radius=20.000;
        Mockito.when(userRepository.exists(username)).thenReturn(false);

        List<UserDTO> response=userService.getInRadius(username,radius);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(0)).findInRadius(Mockito.anyDouble(),Mockito.anyDouble(),Mockito.anyDouble());

        Mockito.reset(userRepository);

    }

    @Test
    public void testGetUsersInRadiusSuccess() throws Exception{
        Double radius=20.000;

        String username1="test1";
        String password1="12345";
        Double latitude1=40.123455;
        Double longitude1=20.1242232;
        String username2="test2";
        String password2="09876";
        Double latitude2=40.123450;
        Double longitude2=20.1245533;

        Coordinates coordinates1=new Coordinates(latitude1,longitude1);
        User user1=new User(username1,password1,coordinates1,true);
        Coordinates coordinates2=new Coordinates(latitude2,longitude2);
        User user2=new User(username2,password2,coordinates2,true);

        List<User> users= new ArrayList<>();
        users.add(user1);

        UserDTO dto1=new UserDTO(username1,password1,latitude1,longitude1,true);
        UserDTO dto2=new UserDTO(username2,password2,latitude2,longitude2,true);
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(dto1);
        userDTOs.add(dto2);

        Mockito.when(userRepository.exists(username1)).thenReturn(true);
        Mockito.when(userRepository.findOne(username1)).thenReturn(user1);
        Mockito.when(userRepository.findInRadius(latitude1,longitude1,radius)).thenReturn(users);
        Mockito.when(userMapper.toDTO(users)).thenReturn(userDTOs);

        List<UserDTO> response=userService.getInRadius(username1,radius);

        assertEquals(response,userDTOs);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findOne(Mockito.anyString());
        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findInRadius(Mockito.anyDouble(),Mockito.anyDouble(),Mockito.anyDouble());

        Mockito.reset(userRepository);

    }

    @Test
    public void testGetAllUsers() throws Exception{
        String username1="test1";
        String password1="12345";
        Double latitude1=40.123455;
        Double longitude1=20.1242232;
        String username2="test2";
        String password2="09876";
        Double latitude2=40.123450;
        Double longitude2=20.1245533;

        Coordinates coordinates1=new Coordinates(latitude1,longitude1);
        User user1=new User(username1,password1,coordinates1,true);
        Coordinates coordinates2=new Coordinates(latitude2,longitude2);
        User user2=new User(username2,password2,coordinates2,true);

        List<User> users= new ArrayList<>();
        users.add(user1);

        UserDTO dto1=new UserDTO(username1,password1,latitude1,longitude1,true);
        UserDTO dto2=new UserDTO(username2,password2,latitude2,longitude2,true);
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(dto1);
        userDTOs.add(dto2);

        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(userMapper.toDTO(users)).thenReturn(userDTOs);

        List<UserDTO> response=userService.getAll();

        assertEquals(response,userDTOs);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).findAll();

        Mockito.reset(userRepository);
    }
}