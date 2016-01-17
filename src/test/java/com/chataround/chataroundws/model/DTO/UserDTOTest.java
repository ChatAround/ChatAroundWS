package com.chataround.chataroundws.model.DTO;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Gewrgia
 */
public class UserDTOTest {

    @Test
    public void testGetUsername() throws Exception {
        final UserDTO dto = new UserDTO();
        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(dto, "test");

        final String result = dto.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final UserDTO dto = new UserDTO();

        dto.setUsername("test");

        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "test");
    }

    @Test
    public void testGetLatitude() throws Exception {
        final UserDTO dto = new UserDTO();
        final Field field = dto.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        Double latitude =42.123456;
        field.set(dto, latitude);

        final Double result = dto.getLatitude();

        Assert.assertEquals(result, latitude);
    }

    @Test
    public void testSetLatitude() throws Exception {
        final UserDTO dto = new UserDTO();
        Double latitude=22.123456;
        dto.setLatitude(latitude);

        final Field field = dto.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), latitude);
    }

    @Test
    public void testGetLongitude() throws Exception {
        final UserDTO dto = new UserDTO();
        final Field field = dto.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        Double longitude =42.123456;
        field.set(dto, longitude);

        final Double result = dto.getLongitude();

        Assert.assertEquals(result, longitude);
    }

    @Test
    public void testGetPassword() throws Exception {
        final UserDTO dto = new UserDTO();
        final Field field = dto.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(dto, "12345");

        final String result = dto.getPassword();

        Assert.assertEquals(result, "12345");
    }

    @Test
    public void testSetPassword() throws Exception {
        final UserDTO dto = new UserDTO();

        dto.setPassword("12345");

        final Field field = dto.getClass().getDeclaredField("password");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "12345");
    }

    @Test
    public void testSetLongitude() throws Exception {
        final UserDTO dto = new UserDTO();
        Double longitude=22.123456;
        dto.setLongitude(longitude);

        final Field field = dto.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), longitude);
    }

    @Test
    public void testIsOnline() throws Exception {
        final UserDTO dto = new UserDTO();
        final Field field = dto.getClass().getDeclaredField("isOnline");
        field.setAccessible(true);
        field.set(dto, true);

        final boolean result = dto.isOnline();

        Assert.assertTrue(result);
    }

    @Test
    public void testSetOnline() throws Exception {
        final UserDTO dto = new UserDTO();

        dto.setOnline(false);

        final Field field = dto.getClass().getDeclaredField("isOnline");
        field.setAccessible(true);
        Assert.assertFalse((Boolean) field.get(dto));
    }
}