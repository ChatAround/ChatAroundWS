package com.chataround.chataroundws.model.entity;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Gewrgia
 */
public class MessageTest {

    @Test
    public void testGetId() throws Exception {
        final Message message = new Message();
        final Field field = message.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Long id=1L;
        field.set(message, id);

        final Long result = message.getId();

        Assert.assertEquals(result, id);
    }


    @Test
    public void testSetId() throws Exception {
        final Message message = new Message();
        Long id=1L;
        message.setId(id);

        final Field field = message.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(message), id);
    }

    @Test
    public void testGetUsername() throws Exception {
        final Message message = new Message();
        final Field field = message.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(message, "test");

        final String result = message.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final Message message = new Message();

        message.setUsername("test");

        final Field field = message.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(message), "test");
    }

    @Test
    public void testGetContent() throws Exception {
        final Message message = new Message();
        final Field field = message.getClass().getDeclaredField("content");
        field.setAccessible(true);
        field.set(message, "Hello");

        final String result = message.getContent();

        Assert.assertEquals(result, "Hello");
    }


    @Test
    public void testSetContent() throws Exception {
        final Message message = new Message();

        message.setContent("Hello");

        final Field field = message.getClass().getDeclaredField("content");
        field.setAccessible(true);
        Assert.assertEquals(field.get(message), "Hello");
    }

    @Test
    public void testGetRadius() throws Exception {
        final Message message = new Message();
        final Field field = message.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        Double radius=100.000;
        field.set(message, radius);

        final Double result = message.getRadius();

        Assert.assertEquals(result, radius);
    }


    @Test
    public void testSetRadius() throws Exception {
        final Message message = new Message();
        Double radius=100.00;
        message.setRadius(radius);

        final Field field = message.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        Assert.assertEquals(field.get(message), radius);
    }

    @Test
    public void testGetDuration() throws Exception {
        final Message message = new Message();
        final Field field = message.getClass().getDeclaredField("duration");
        field.setAccessible(true);
        int duration=60;
        field.set(message, duration);

        final int result = message.getDuration();

        Assert.assertEquals(result, duration);
    }


    @Test
    public void testSetDuration() throws Exception {
        final Message message = new Message();
        int duration=60;
        message.setDuration(duration);

        final Field field = message.getClass().getDeclaredField("duration");
        field.setAccessible(true);
        Assert.assertEquals(field.get(message), duration);
    }
}