package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.UserDTO;
import com.chataround.chataroundws.model.entity.Coordinates;
import com.chataround.chataroundws.model.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gewrgia
 */

public class UserMapperTest {

    IMapper<User,UserDTO> userMapper=new UserMapper();


    @Test
    public void testFromDTO() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;

        UserDTO dto = new UserDTO(username,password,latitude,longitude,isOnline);
        User user=userMapper.fromDTO(dto);

        Assert.assertEquals(user.getUsername(),dto.getUsername());
        Assert.assertEquals(user.getPassword(),dto.getPassword());
        Assert.assertEquals(user.getCoordinates().getLatitude(),dto.getLatitude());
        Assert.assertEquals(user.getCoordinates().getLongitude(),dto.getLongitude());
        Assert.assertEquals(user.isOnline(),dto.isOnline());
    }

    @Test
    public void testFromDTOList() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;
        UserDTO dto = new UserDTO(username,password,latitude,longitude,isOnline);
        String username1="test1";
        String password1="54321";
        Double latitude1=41.989823;
        Double longitude1=21.76539;
        Boolean isOnline1=false;
        UserDTO dto1 = new UserDTO(username1,password1,latitude1,longitude1,isOnline1);

        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(dto);
        userDTOs.add(dto1);

        List<User> users =userMapper.fromDTO(userDTOs);

        Assert.assertEquals(users.get(0).getUsername(),dto.getUsername());
        Assert.assertEquals(users.get(1).getUsername(),dto1.getUsername());
        Assert.assertEquals(users.get(0).getPassword(),dto.getPassword());
        Assert.assertEquals(users.get(1).getPassword(),dto1.getPassword());
        Assert.assertEquals(users.get(0).getCoordinates().getLatitude(),dto.getLatitude());
        Assert.assertEquals(users.get(1).getCoordinates().getLatitude(),dto1.getLatitude());
        Assert.assertEquals(users.get(0).getCoordinates().getLongitude(),dto.getLongitude());
        Assert.assertEquals(users.get(1).getCoordinates().getLongitude(),dto1.getLongitude());
        Assert.assertEquals(users.get(0).isOnline(),dto.isOnline());
        Assert.assertEquals(users.get(1).isOnline(),dto1.isOnline());




    }

    @Test
    public void testToDTO() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;
        Coordinates coordinates=new Coordinates(latitude,longitude);
        User user = new User(username,password,coordinates,isOnline);

        UserDTO dto=userMapper.toDTO(user);

        Assert.assertEquals(user.getUsername(),dto.getUsername());
        Assert.assertNull(user.getPassword(),dto.getPassword());
        Assert.assertEquals(user.getCoordinates().getLatitude(),dto.getLatitude());
        Assert.assertEquals(user.getCoordinates().getLongitude(),dto.getLongitude());
        Assert.assertEquals(user.isOnline(),dto.isOnline());
    }

    @Test
    public void testToDTOList() throws Exception {

        String username="test";
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;
        Coordinates coordinates=new Coordinates(latitude,longitude);
        User user = new User(username,password,coordinates,isOnline);
        String username1="test1";
        String password1="54321";
        Double latitude1=41.989823;
        Double longitude1=21.76539;
        Boolean isOnline1=false;
        Coordinates coordinates1=new Coordinates(latitude1,longitude1);
        User user1 = new User(username1,password1,coordinates1,isOnline1);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        List<UserDTO> userDTOs=userMapper.toDTO(users);
        Assert.assertEquals(userDTOs.get(0).getUsername(),user.getUsername());
        Assert.assertEquals(userDTOs.get(1).getUsername(),user1.getUsername());
        Assert.assertNull(userDTOs.get(0).getPassword());
        Assert.assertNull(userDTOs.get(1).getPassword());
        Assert.assertEquals(userDTOs.get(0).getLatitude(),user.getCoordinates().getLatitude());
        Assert.assertEquals(userDTOs.get(1).getLatitude(),user1.getCoordinates().getLatitude());
        Assert.assertEquals(userDTOs.get(0).getLongitude(),user.getCoordinates().getLongitude());
        Assert.assertEquals(userDTOs.get(1).getLongitude(),user1.getCoordinates().getLongitude());
        Assert.assertEquals(userDTOs.get(0).isOnline(),user.isOnline());
        Assert.assertEquals(userDTOs.get(1).isOnline(),user1.isOnline());

    }
}