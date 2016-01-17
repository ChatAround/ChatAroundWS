package com.chataround.chataroundws.model.entity;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Gewrgia
 */
public class UserTest {

    @Test
    public void testGetCoordinates() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("coordinates");
        field.setAccessible(true);
        Coordinates coordinates=new Coordinates(40.12345,22.12345);
        field.set(user, coordinates);

        final Coordinates result = user.getCoordinates();

        Assert.assertEquals(result, coordinates);
    }

    @Test
    public void testSetCoordinates() throws Exception {
        final User user = new User();
        Coordinates coordinates=new Coordinates(40.12345,22.12345);
        user.setCoordinates(coordinates);

        final Field field = user.getClass().getDeclaredField("coordinates");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), coordinates);
    }

    @Test
    public void testGetUsername() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(user, "test");

        final String result = user.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final User user = new User();

        user.setUsername("test");

        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), "test");
    }

    @Test
    public void testGetPassword() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(user, "12345");

        final String result = user.getPassword();

        Assert.assertEquals(result, "12345");
    }

    @Test
    public void testSetPassword() throws Exception {
        final User user = new User();

        user.setPassword("12345");

        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), "12345");
    }

    @Test
    public void testIsOnline() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("isOnline");
        field.setAccessible(true);
        field.set(user, true);

        final boolean result = user.isOnline();

        Assert.assertTrue(result);
    }

    @Test
    public void testSetOnline() throws Exception {
        final User user = new User();

        user.setOnline(false);

        final Field field = user.getClass().getDeclaredField("isOnline");
        field.setAccessible(true);
        Assert.assertFalse((Boolean) field.get(user));
    }

}