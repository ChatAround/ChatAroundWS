package com.chataround.chataroundws.TestRepository;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.model.entity.Coordinates;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.repository.UserRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gewrgia
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;



    @Test
    @Transactional
    public void testInsertUser() throws Exception{
        String username="test";
        String password="12345";
        Double latitude=40.12345;
        Double longitude=22.098765;
        Coordinates coordinates=new Coordinates(latitude,longitude);
        boolean isOnline=true;
        User user=new User(username,password,coordinates,isOnline);
        userRepository.saveAndFlush(user);

        User dbUser=userRepository.findOne(username);


        Assert.assertNotNull(dbUser);
        Assert.assertEquals(username, dbUser.getUsername());
        Assert.assertEquals(password,dbUser.getPassword());
        Assert.assertEquals(latitude,dbUser.getCoordinates().getLatitude());
        Assert.assertEquals(longitude,dbUser.getCoordinates().getLongitude());
        Assert.assertEquals(isOnline,dbUser.isOnline());

        userRepository.delete(username);
    }

    @Test
    public void testFindOneSuccess() throws Exception{
        String username="Maria";
        Double latitude=41.089438;
        Double longitude=23.544533;
        User dbUser=userRepository.findOne(username);

        Assert.assertNotNull(dbUser);
        Assert.assertEquals(username, dbUser.getUsername());
        Assert.assertEquals("mpla",dbUser.getPassword());
        Assert.assertEquals(latitude ,dbUser.getCoordinates().getLatitude());
        Assert.assertEquals(longitude,dbUser.getCoordinates().getLongitude());
        Assert.assertEquals(true,dbUser.isOnline());

    }


    @Test
    public void testFindOneFail() throws Exception{
        String username="test";

        User dbUser=userRepository.findOne(username);

        Assert.assertNull(dbUser);

    }

    @Test
    public void testExistsSuccess() throws Exception{
        String username="Maria";

        Boolean exists=userRepository.exists(username);

        Assert.assertNotNull(exists);
        Assert.assertEquals(true,exists);

    }

    @Test
    public void testExistsFail() throws Exception{
        String username="test";

        Boolean exists=userRepository.exists(username);

        Assert.assertNotNull(exists);
        Assert.assertEquals(false,exists);

    }

    @Test
    @Transactional
    public void testDeleteUser() throws Exception{
        String username="test";
        String password="12345";
        Double latitude=40.12345;
        Double longitude=22.098765;
        Coordinates coordinates=new Coordinates(latitude,longitude);
        boolean isOnline=true;
        User user=new User(username,password,coordinates,isOnline);
        userRepository.saveAndFlush(user);

        User dbUser=userRepository.findOne(username);

        Assert.assertNotNull(dbUser);
        Assert.assertEquals(username, dbUser.getUsername());
        Assert.assertEquals(password,dbUser.getPassword());
        Assert.assertEquals(latitude,dbUser.getCoordinates().getLatitude());
        Assert.assertEquals(longitude,dbUser.getCoordinates().getLongitude());
        Assert.assertEquals(isOnline,dbUser.isOnline());

        userRepository.delete(username);
        User dbUser2=userRepository.findOne(username);
        Assert.assertNull(dbUser2);

    }

    @Test
    @Transactional
    public void testUpdateUser() throws Exception{
        String username="Maria";
        String password="mpla";
        Double latitude=41.089438;
        Double longitude=23.544533;

        User dbUser=userRepository.findOne(username);

        Assert.assertNotNull(dbUser);
        Assert.assertEquals(username, dbUser.getUsername());
        Assert.assertEquals(password,dbUser.getPassword());
        Assert.assertEquals(latitude ,dbUser.getCoordinates().getLatitude());
        Assert.assertEquals(longitude,dbUser.getCoordinates().getLongitude());
        Assert.assertEquals(true,dbUser.isOnline());

        String password2="12345";
        Double latitude2=40.12345;
        Double longitude2=22.098765;
        Coordinates coordinates=new Coordinates(latitude,longitude);
        boolean isOnline=true;
        User user=new User(username,password2,coordinates,isOnline);
        userRepository.save(user);

        User updated=userRepository.findOne(username);


        Assert.assertNotNull(updated);
        Assert.assertEquals(username, updated.getUsername());
        Assert.assertEquals(password2,updated.getPassword());
        Assert.assertEquals(latitude,updated.getCoordinates().getLatitude());
        Assert.assertEquals(longitude,updated.getCoordinates().getLongitude());
        Assert.assertEquals(isOnline,updated.isOnline());
    }

    @Test
    public void testGetAllUsers() throws Exception{
        Double latitude=41.089438;
        Double latitude1=41.0839519;
        Double latitude2=41.0769825;
        Double latitude3=41.0747267;
        Double longitude=23.544533;
        Double longitude1=23.5520611;
        Double longitude2=23.5420477;
        Double longitude3=23.5540053;

        List<User> users= userRepository.findAll();

        Assert.assertNotNull(users);
        Assert.assertEquals(4, users.size());
        Assert.assertEquals("Maria",users.get(0).getUsername());
        Assert.assertEquals("Eleni",users.get(1).getUsername());
        Assert.assertEquals("Giannis",users.get(2).getUsername());
        Assert.assertEquals("Giorgos",users.get(3).getUsername());
        Assert.assertEquals("mpla",users.get(0).getPassword());
        Assert.assertEquals("mpla",users.get(1).getPassword());
        Assert.assertEquals("mpla",users.get(2).getPassword());
        Assert.assertEquals("mpla",users.get(3).getPassword());
        Assert.assertEquals(latitude,users.get(0).getCoordinates().getLatitude());
        Assert.assertEquals(latitude1,users.get(1).getCoordinates().getLatitude());
        Assert.assertEquals(latitude2,users.get(2).getCoordinates().getLatitude());
        Assert.assertEquals(latitude3,users.get(3).getCoordinates().getLatitude());
        Assert.assertEquals(longitude,users.get(0).getCoordinates().getLongitude());
        Assert.assertEquals(longitude1,users.get(1).getCoordinates().getLongitude());
        Assert.assertEquals(longitude2,users.get(2).getCoordinates().getLongitude());
        Assert.assertEquals(longitude3,users.get(3).getCoordinates().getLongitude());
        Assert.assertEquals(true,users.get(0).isOnline());
        Assert.assertEquals(true,users.get(1).isOnline());
        Assert.assertEquals(true,users.get(2).isOnline());
        Assert.assertEquals(true,users.get(3).isOnline());
    }

    @Test
    public void testGetUsersInRadius() throws  Exception{
        Double latitude=41.089438;
        Double latitude1=41.0839519;
        Double longitude=23.544533;
        Double longitude1=23.5520611;

        List<User> users= userRepository.findInRadius(41.089438,23.544533,1000.000);
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        Assert.assertEquals("Maria",users.get(0).getUsername());
        Assert.assertEquals("Eleni",users.get(1).getUsername());
        Assert.assertEquals("mpla",users.get(0).getPassword());
        Assert.assertEquals("mpla",users.get(1).getPassword());
        Assert.assertEquals(latitude,users.get(0).getCoordinates().getLatitude());
        Assert.assertEquals(latitude1,users.get(1).getCoordinates().getLatitude());
        Assert.assertEquals(longitude,users.get(0).getCoordinates().getLongitude());
        Assert.assertEquals(longitude1,users.get(1).getCoordinates().getLongitude());
        Assert.assertEquals(true,users.get(0).isOnline());
        Assert.assertEquals(true,users.get(1).isOnline());
    }


}
