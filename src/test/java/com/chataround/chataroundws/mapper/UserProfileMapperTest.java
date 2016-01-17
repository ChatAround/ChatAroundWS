package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.model.entity.UserProfile;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gewrgia
 */
public class UserProfileMapperTest {

    IMapper<UserProfile,UserProfileDTO> userProfileMapper=new UserProfileMapper();

    @Test
    public void testFromDTO() throws Exception {
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

        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,
        gender, country,city,birthday,about);

        UserProfile profile=userProfileMapper.fromDTO(dto);

        Assert.assertEquals(profile.getUsername(),dto.getUsername());
        Assert.assertEquals(profile.getFirstName(),dto.getFirstName());
        Assert.assertEquals(profile.getSurName(),dto.getSurName());
        Assert.assertEquals(profile.getGender(),dto.getGender());
        Assert.assertEquals(profile.getCountry(),dto. getCountry());
        Assert.assertEquals(profile.getCity(),dto.getCity());
        Assert.assertEquals(profile.getBirthday(),dto.getBirthday());
        Assert.assertEquals(profile.getAbout(),dto.getAbout());
    }

    @Test
    public void testFromDTO1() throws Exception {
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

        UserProfileDTO dto=new UserProfileDTO(username,firstName,surName,
                gender, country,city,birthday,about);

        String username1="test1";
        String firstName1="Test1";
        String surName1="Tester1";
        String gender1="male1";
        String country1="Italy";
        String city1="Rome";
        Date birthday1 = sd.parse(s);
        String about1= "mplelelel";

        UserProfileDTO dto1=new UserProfileDTO(username1,firstName1,surName1,
                gender1, country1,city1,birthday1,about1);

        List<UserProfileDTO> dtos =new ArrayList<>();
        dtos.add(dto);
        dtos.add(dto1);

        List<UserProfile> profiles=userProfileMapper.fromDTO(dtos);

        Assert.assertEquals(profiles.get(0).getUsername(), dtos.get(0).getUsername());
        Assert.assertEquals(profiles.get(0).getFirstName(),dtos.get(0).getFirstName());
        Assert.assertEquals(profiles.get(0).getSurName(),  dtos.get(0).getSurName());
        Assert.assertEquals(profiles.get(0).getGender(),   dtos.get(0).getGender());
        Assert.assertEquals(profiles.get(0).getCountry(),  dtos.get(0). getCountry());
        Assert.assertEquals(profiles.get(0).getCity(),     dtos.get(0).getCity());
        Assert.assertEquals(profiles.get(0).getBirthday(), dtos.get(0).getBirthday());
        Assert.assertEquals(profiles.get(0).getAbout(),    dtos.get(0).getAbout());
        Assert.assertEquals(profiles.get(1).getUsername(), dtos.get(1).getUsername());
        Assert.assertEquals(profiles.get(1).getFirstName(),dtos.get(1).getFirstName());
        Assert.assertEquals(profiles.get(1).getSurName(),  dtos.get(1).getSurName());
        Assert.assertEquals(profiles.get(1).getGender(),   dtos.get(1).getGender());
        Assert.assertEquals(profiles.get(1).getCountry(),  dtos.get(1). getCountry());
        Assert.assertEquals(profiles.get(1).getCity(),     dtos.get(1).getCity());
        Assert.assertEquals(profiles.get(1).getBirthday(), dtos.get(1).getBirthday());
        Assert.assertEquals(profiles.get(1).getAbout(),    dtos.get(1).getAbout());
    }

    @Test
    public void testToDTO() throws Exception {
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

        UserProfile profile=new UserProfile(username,firstName,surName,
                gender, country,city,birthday,about);

        UserProfileDTO dto=userProfileMapper.toDTO(profile);

        Assert.assertEquals(profile.getUsername(),dto.getUsername());
        Assert.assertEquals(profile.getFirstName(),dto.getFirstName());
        Assert.assertEquals(profile.getSurName(),dto.getSurName());
        Assert.assertEquals(profile.getGender(),dto.getGender());
        Assert.assertEquals(profile.getCountry(),dto. getCountry());
        Assert.assertEquals(profile.getCity(),dto.getCity());
        Assert.assertEquals(profile.getBirthday(),dto.getBirthday());
        Assert.assertEquals(profile.getAbout(),dto.getAbout());
    }

    @Test
    public void testToDTO1() throws Exception {
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

        UserProfile profile=new UserProfile(username,firstName,surName,
                gender, country,city,birthday,about);

        String username1="test1";
        String firstName1="Test1";
        String surName1="Tester1";
        String gender1="male1";
        String country1="Italy";
        String city1="Rome";
        Date birthday1 = sd.parse(s);
        String about1= "mplelelel";

        UserProfile profile1=new UserProfile(username1,firstName1,surName1,
                gender1, country1,city1,birthday1,about1);

        List<UserProfile> profiles =new ArrayList<>();
        profiles.add(profile);
        profiles.add(profile1);

        List<UserProfileDTO> dtos=userProfileMapper.toDTO(profiles);

        Assert.assertEquals(profiles.get(0).getUsername(), dtos.get(0).getUsername());
        Assert.assertEquals(profiles.get(0).getFirstName(),dtos.get(0).getFirstName());
        Assert.assertEquals(profiles.get(0).getSurName(),  dtos.get(0).getSurName());
        Assert.assertEquals(profiles.get(0).getGender(),   dtos.get(0).getGender());
        Assert.assertEquals(profiles.get(0).getCountry(),  dtos.get(0). getCountry());
        Assert.assertEquals(profiles.get(0).getCity(),     dtos.get(0).getCity());
        Assert.assertEquals(profiles.get(0).getBirthday(), dtos.get(0).getBirthday());
        Assert.assertEquals(profiles.get(0).getAbout(),    dtos.get(0).getAbout());
        Assert.assertEquals(profiles.get(1).getUsername(), dtos.get(1).getUsername());
        Assert.assertEquals(profiles.get(1).getFirstName(),dtos.get(1).getFirstName());
        Assert.assertEquals(profiles.get(1).getSurName(),  dtos.get(1).getSurName());
        Assert.assertEquals(profiles.get(1).getGender(),   dtos.get(1).getGender());
        Assert.assertEquals(profiles.get(1).getCountry(),  dtos.get(1). getCountry());
        Assert.assertEquals(profiles.get(1).getCity(),     dtos.get(1).getCity());
        Assert.assertEquals(profiles.get(1).getBirthday(), dtos.get(1).getBirthday());
        Assert.assertEquals(profiles.get(1).getAbout(),    dtos.get(1).getAbout());
    }
}