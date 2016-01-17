package com.chataround.chataroundws.model.DTO;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gewrgia
 */
public class UserProfileDTOTest {

    @Test
    public void testGetUsername() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(dto, "test");

        final String result = dto.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setUsername("test");

        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "test");
    }

    @Test
    public void testGetFirstName() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(dto, "test");

        final String result = dto.getFirstName();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetFirstName() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setFirstName("test");

        final Field field = dto.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "test");
    }

    @Test
    public void testGetSurName() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("surName");
        field.setAccessible(true);
        field.set(dto, "test");

        final String result = dto.getSurName();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetSurName() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setSurName("test");

        final Field field = dto.getClass().getDeclaredField("surName");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "test");
    }

    @Test
    public void testGetGender() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("gender");
        field.setAccessible(true);
        field.set(dto, "male");

        final String result = dto.getGender();

        Assert.assertEquals(result, "male");
    }

    @Test
    public void testSetGender() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setGender("male");

        final Field field = dto.getClass().getDeclaredField("gender");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "male");
    }

    @Test
    public void testGetCountry() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("country");
        field.setAccessible(true);
        field.set(dto, "Greece");

        final String result = dto.getCountry();

        Assert.assertEquals(result, "Greece");
    }

    @Test
    public void testSetCountry() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setCountry("Greece");

        final Field field = dto.getClass().getDeclaredField("country");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "Greece");
    }

    @Test
    public void testGetCity() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("city");
        field.setAccessible(true);
        field.set(dto, "Serres");

        final String result = dto.getCity();

        Assert.assertEquals(result, "Serres");
    }

    @Test
    public void testSetCity() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setCity("Serres");

        final Field field = dto.getClass().getDeclaredField("city");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "Serres");
    }

    @Test
    public void testGetBirthday() throws Exception {
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        field.set(dto, birthday);

        final Date result = dto.getBirthday();

        Assert.assertEquals(result, birthday);
    }

    @Test
    public void testSetBirthday() throws Exception {
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setBirthday(birthday);

        final Field field = dto.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), birthday);
    }

    @Test
    public void testGetAbout() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();
        final Field field = dto.getClass().getDeclaredField("about");
        field.setAccessible(true);
        field.set(dto, "mplampla");

        final String result = dto.getAbout();

        Assert.assertEquals(result, "mplampla");
    }

    @Test
    public void testSetAbout() throws Exception {
        final UserProfileDTO dto = new UserProfileDTO();

        dto.setAbout("mplampla");

        final Field field = dto.getClass().getDeclaredField("about");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "mplampla");
    }
}