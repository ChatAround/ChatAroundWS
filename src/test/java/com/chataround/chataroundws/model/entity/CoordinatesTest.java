package com.chataround.chataroundws.model.entity;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Gewrgia
 */
public class CoordinatesTest {

    @Test
    public void testGetLatitude() throws Exception {
        final Coordinates coordinates = new Coordinates();
        final Field field = coordinates.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        Double latitude =42.123456;
        field.set(coordinates, latitude);

        final Double result = coordinates.getLatitude();

        Assert.assertEquals(result, latitude);
    }

    @Test
    public void testSetLatitude() throws Exception {
        final Coordinates coordinates = new Coordinates();
        Double latitude=22.123456;
        coordinates.setLatitude(latitude);

        final Field field = coordinates.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(coordinates), latitude);
    }

    @Test
    public void testGetLongitude() throws Exception {
        final Coordinates coordinates = new Coordinates();
        final Field field = coordinates.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        Double longitude =42.123456;
        field.set(coordinates, longitude);

        final Double result = coordinates.getLongitude();

        Assert.assertEquals(result, longitude);
    }

    @Test
    public void testSetLongitude() throws Exception {
        final Coordinates coordinates = new Coordinates();
        Double longitude=22.123456;
        coordinates.setLongitude(longitude);

        final Field field = coordinates.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(coordinates), longitude);
    }

}