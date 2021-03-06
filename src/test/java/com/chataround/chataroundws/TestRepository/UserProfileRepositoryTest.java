package com.chataround.chataroundws.TestRepository;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.model.entity.UserProfile;
import com.chataround.chataroundws.repository.UserProfileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolationException;
import java.util.Date;

/**
 * @author Gewrgia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository userProfileRepository;


    @Test
    public void testUserProfileExistsSuccess() throws Exception{

        Boolean exists=userProfileRepository.exists("Maria");
        Assert.assertNotNull(exists);
        Assert.assertTrue(exists);
    }


    @Test
    public void testUserProfileExistsFailProfileDoesNotExists() throws Exception{

        Boolean exists=userProfileRepository.exists("test");
        Assert.assertNotNull(exists);
        Assert.assertFalse(exists);
    }
    @Test(expected = InvalidDataAccessResourceUsageException.class)
    public void testUserProfileExistsFailNullUsername() throws Exception{
        String username=null;
        Boolean exists=userProfileRepository.exists(username);

    }

    @Test
    public void testFindOneUserProfileSuccess() throws Exception{

        String username="Maria";
        String firstName="Maria";
        String surName="Papadopoulou";
        String gender="female";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile userProfile=userProfileRepository.findOne(username);

        Assert.assertNotNull(userProfile);
        Assert.assertEquals(username,userProfile.getUsername());
        Assert.assertEquals(firstName,userProfile.getFirstName());
        Assert.assertEquals(surName, userProfile.getSurName());
        Assert.assertEquals(gender,userProfile.getGender());
        Assert.assertEquals(country,userProfile.getCountry());
        Assert.assertEquals(city,userProfile.getCity());
        Assert.assertEquals(about,userProfile.getAbout());
        Assert.assertEquals(birthday,userProfile.getBirthday());

    }

    @Test(expected = InvalidDataAccessResourceUsageException.class)
    public void testFindOneUserProfileFailUseProfilerDoesNotExists() throws Exception{
        String username=null;
        UserProfile userProfile=userProfileRepository.findOne(username);

    }

    @Test
    public void testFindOneUserProfileFailNullUsername() throws Exception{

        UserProfile userProfile=userProfileRepository.findOne("test");
        Assert.assertNull(userProfile);
    }
    @Test
    public void testAddUserProfileSuccess() throws Exception{

        String username="test";
        String firstName="Test";
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile find=userProfileRepository.findOne(username);
        Assert.assertNull(find);

        UserProfile userProfile=new UserProfile(
                username,
                firstName,
                surName,
                gender,
                country,
                city,
                birthday,
                about

        );

        userProfileRepository.saveAndFlush(userProfile);

        UserProfile added=userProfileRepository.findOne(username);


        Assert.assertNotNull(added);
        Assert.assertEquals(username,added.getUsername());
        Assert.assertEquals(firstName,added.getFirstName());
        Assert.assertEquals(surName, added.getSurName());
        Assert.assertEquals(gender,added.getGender());
        Assert.assertEquals(country,added.getCountry());
        Assert.assertEquals(city,added.getCity());
        Assert.assertEquals(about,added.getAbout());
        Assert.assertEquals(birthday,added.getBirthday());

        userProfileRepository.delete(username);
    }
    @Test(expected = InvalidDataAccessResourceUsageException.class)
    public void testAddUserProfileFailNullUsername() throws Exception{

        String username=null;
        String firstName="Test";
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile find=userProfileRepository.findOne(username);
        Assert.assertNull(find);

        UserProfile userProfile=new UserProfile(
                username, firstName, surName, gender, country,
                city, birthday, about);

        userProfileRepository.saveAndFlush(userProfile);

    }
    @Test(expected = ConstraintViolationException.class)
    public void testAddUserProfileFailNullProperties() throws Exception{

        String username="test";
        String firstName=null;
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile find=userProfileRepository.findOne(username);
        Assert.assertNull(find);

        UserProfile userProfile=new UserProfile(
                username, firstName, surName, gender, country,
                city, birthday, about);

        userProfileRepository.saveAndFlush(userProfile);

    }
    @Test(expected = ConstraintViolationException.class)
    public void testAddUserProfileFailUsernameSmallerThanMin() throws Exception{

        String username="tes";
        String firstName="Test";
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile userProfile=new UserProfile(
                username, firstName, surName, gender, country,
                city, birthday, about);

        userProfileRepository.saveAndFlush(userProfile);

    }

    @Test(expected = ConstraintViolationException.class)
    public void testAddUserProfileFailUsernameExceedsMax() throws Exception{

        String username="test123456789123456";
        String firstName="Test";
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile userProfile=new UserProfile(
                username, firstName, surName, gender, country,
                city, birthday, about);

        userProfileRepository.saveAndFlush(userProfile);

    }
    @Test
    public void testUpdateUserProfileSuccess() throws Exception{
        String username="Maria";
        String firstName="Maria";
        String surName="Papadopoulou";
        String gender="female";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile userProfile=userProfileRepository.findOne(username);

        Assert.assertNotNull(userProfile);
        Assert.assertEquals(username,userProfile.getUsername());
        Assert.assertEquals(firstName,userProfile.getFirstName());
        Assert.assertEquals(surName, userProfile.getSurName());
        Assert.assertEquals(gender,userProfile.getGender());
        Assert.assertEquals(country,userProfile.getCountry());
        Assert.assertEquals(city,userProfile.getCity());
        Assert.assertEquals(about,userProfile.getAbout());
        Assert.assertEquals(birthday,userProfile.getBirthday());

        String up_firstName="Marios";
        String up_surName="Nikolaidis";
        String up_gender="male";
        String up_country="Agglia";
        String up_city="Londino";
        Date   up_birthday=null;
        String up_about="alalalla";


        UserProfile up_userProfile=new UserProfile(
                username,
                up_firstName,
                up_surName,
                up_gender,
                up_country,
                up_city,
                up_birthday,
                up_about

        );
        userProfileRepository.save(up_userProfile);
        UserProfile updated=userProfileRepository.findOne(username);

        Assert.assertNotNull(updated);
        Assert.assertEquals(username,updated.getUsername());
        Assert.assertEquals(up_firstName,updated.getFirstName());
        Assert.assertEquals(up_surName, updated.getSurName());
        Assert.assertEquals(up_gender,updated.getGender());
        Assert.assertEquals(up_country,updated.getCountry());
        Assert.assertEquals(up_city,updated.getCity());
        Assert.assertEquals(up_about,updated.getAbout());
        Assert.assertEquals(up_birthday,updated.getBirthday());

        userProfileRepository.save(userProfile);

    }

    @Test(expected = TransactionSystemException.class)
    public void testUpdateUserProfileFailNullProperties() throws Exception{
        String username="Maria";
        String up_firstName=null;
        String up_surName="Nikolaidis";
        String up_gender="male";
        String up_country="Agglia";
        String up_city="Londino";
        Date   up_birthday=null;
        String up_about="alalalla";


        UserProfile up_userProfile=new UserProfile(
                username,
                up_firstName,
                up_surName,
                up_gender,
                up_country,
                up_city,
                up_birthday,
                up_about

        );
        userProfileRepository.save(up_userProfile);
    }
    @Test(expected = JpaSystemException.class)
    public void testUpdateUserProfileFailNullUsername() throws Exception{
        String username=null;
        String up_firstName="Mrios";
        String up_surName="Nikolaidis";
        String up_gender="male";
        String up_country="Agglia";
        String up_city="Londino";
        Date   up_birthday=null;
        String up_about="alalalla";


        UserProfile up_userProfile=new UserProfile(
                username, up_firstName, up_surName, up_gender,
                up_country, up_city, up_birthday, up_about

        );
        userProfileRepository.save(up_userProfile);
    }



    @Test
    public void testDeleteUserProfile() throws Exception{

        String username="test";
        String firstName="Test";
        String surName="Testos";
        String gender="male";
        String country="Greece";
        String city="Serres";
        Date birthday=null;
        String about="mplampa";

        UserProfile find=userProfileRepository.findOne(username);
        Assert.assertNull(find);

        UserProfile userProfile=new UserProfile(
                username,
                firstName,
                surName,
                gender,
                country,
                city,
                birthday,
                about

        );

        userProfileRepository.saveAndFlush(userProfile);

        UserProfile added=userProfileRepository.findOne(username);


        Assert.assertNotNull(added);
        Assert.assertEquals(username,added.getUsername());
        Assert.assertEquals(firstName,added.getFirstName());
        Assert.assertEquals(surName, added.getSurName());
        Assert.assertEquals(gender,added.getGender());
        Assert.assertEquals(country,added.getCountry());
        Assert.assertEquals(city,added.getCity());
        Assert.assertEquals(about,added.getAbout());
        Assert.assertEquals(birthday,added.getBirthday());

        userProfileRepository.delete(username);

        UserProfile deleted=userProfileRepository.findOne(username);
        Assert.assertNull(deleted);

    }


    @Test(expected = InvalidDataAccessResourceUsageException.class)
    public void testDeleteUserProfileFailNullUsername() throws Exception {
        String username=null;
        userProfileRepository.delete(username);
    }
}
