package com.chataround.chataroundws.model.DTO;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Gewrgia
 */
public class MessageDTOTest {

    @Test
    public void testGetId() throws Exception {
        final MessageDTO dto = new MessageDTO();
        final Field field = dto.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Long id=1L;
        field.set(dto, id);

        final Long result = dto.getId();

        Assert.assertEquals(result, id);
    }


    @Test
    public void testSetId() throws Exception {
        final MessageDTO dto = new MessageDTO();
        Long id=1L;
        dto.setId(id);

        final Field field = dto.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), id);
    }

    @Test
    public void testGetUsername() throws Exception {
        final MessageDTO dto = new MessageDTO();
        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(dto, "test");

        final String result = dto.getUsername();

        Assert.assertEquals(result, "test");
    }

    @Test
    public void testSetUsername() throws Exception {
        final MessageDTO dto = new MessageDTO();

        dto.setUsername("test");

        final Field field = dto.getClass().getDeclaredField("username");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "test");
    }

    @Test
    public void testGetContent() throws Exception {
        final MessageDTO dto = new MessageDTO();
        final Field field = dto.getClass().getDeclaredField("content");
        field.setAccessible(true);
        field.set(dto, "Hello");

        final String result = dto.getContent();

        Assert.assertEquals(result, "Hello");
    }


    @Test
    public void testSetContent() throws Exception {
        final MessageDTO dto = new MessageDTO();

        dto.setContent("Hello");

        final Field field = dto.getClass().getDeclaredField("content");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), "Hello");
    }

    @Test
    public void testGetRadius() throws Exception {
        final MessageDTO dto = new MessageDTO();
        final Field field = dto.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        Double radius=100.000;
        field.set(dto, radius);

        final Double result = dto.getRadius();

        Assert.assertEquals(result, radius);
    }


    @Test
    public void testSetRadius() throws Exception {
        final MessageDTO dto = new MessageDTO();
        Double radius=100.00;
        dto.setRadius(radius);

        final Field field = dto.getClass().getDeclaredField("radius");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), radius);
    }

    @Test
    public void testGetDuration() throws Exception {
        final MessageDTO dto = new MessageDTO();
        final Field field = dto.getClass().getDeclaredField("duration");
        field.setAccessible(true);
        int duration=60;
        field.set(dto, duration);

        final int result = dto.getDuration();

        Assert.assertEquals(result, duration);
    }


    @Test
    public void testSetDuration() throws Exception {
        final MessageDTO dto = new MessageDTO();
        int duration=60;
        dto.setDuration(duration);

        final Field field = dto.getClass().getDeclaredField("duration");
        field.setAccessible(true);
        Assert.assertEquals(field.get(dto), duration);
    }
}