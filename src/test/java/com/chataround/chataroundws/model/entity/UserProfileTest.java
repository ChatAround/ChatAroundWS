package com.chataround.chataroundws.model.entity;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gewrgia
 */
public class UserProfileTest {

    @Test
    public void testGetUsername() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(profile, "test");

        final String result = profile.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setUsername("test");

        final Field field = profile.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "test");
    }

    @Test
    public void testGetFirstName() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(profile, "test");

        final String result = profile.getFirstName();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetFirstName() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setFirstName("test");

        final Field field = profile.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "test");
    }

    @Test
    public void testGetSurName() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("surName");
        field.setAccessible(true);
        field.set(profile, "test");

        final String result = profile.getSurName();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetSurName() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setSurName("test");

        final Field field = profile.getClass().getDeclaredField("surName");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "test");
    }

    @Test
    public void testGetGender() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("gender");
        field.setAccessible(true);
        field.set(profile, "male");

        final String result = profile.getGender();

        Assert.assertEquals(result, "male");
    }

    @Test
    public void testSetGender() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setGender("male");

        final Field field = profile.getClass().getDeclaredField("gender");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "male");
    }

    @Test
    public void testGetCountry() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("country");
        field.setAccessible(true);
        field.set(profile, "Greece");

        final String result = profile.getCountry();

        Assert.assertEquals(result, "Greece");
    }

    @Test
    public void testSetCountry() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setCountry("Greece");

        final Field field = profile.getClass().getDeclaredField("country");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "Greece");
    }

    @Test
    public void testGetCity() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("city");
        field.setAccessible(true);
        field.set(profile, "Serres");

        final String result = profile.getCity();

        Assert.assertEquals(result, "Serres");
    }

    @Test
    public void testSetCity() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setCity("Serres");

        final Field field = profile.getClass().getDeclaredField("city");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "Serres");
    }

    @Test
    public void testGetBirthday() throws Exception {
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        field.set(profile, birthday);

        final Date result = profile.getBirthday();

        Assert.assertEquals(result, birthday);
    }

    @Test
    public void testSetBirthday() throws Exception {
        String s = "1993/09/22";
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        Date birthday = sd.parse(s);
        final UserProfile profile = new UserProfile();

        profile.setBirthday(birthday);

        final Field field = profile.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), birthday);
    }

    @Test
    public void testGetAbout() throws Exception {
        final UserProfile profile = new UserProfile();
        final Field field = profile.getClass().getDeclaredField("about");
        field.setAccessible(true);
        field.set(profile, "mplampla");

        final String result = profile.getAbout();

        Assert.assertEquals(result, "mplampla");
    }

    @Test
    public void testSetAbout() throws Exception {
        final UserProfile profile = new UserProfile();

        profile.setAbout("mplampla");

        final Field field = profile.getClass().getDeclaredField("about");
        field.setAccessible(true);
        Assert.assertEquals(field.get(profile), "mplampla");
    }
}