package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gewrgia
 */
public class MessageMapperTest {

    IMapper<Message,MessageDTO> messageMapper=new MessageMapper();

    @Test
    public void testFromDTO() throws Exception {

        String username="testUser";
        String content="Hello";
        Double radius=100.00;
        int duration= 10;
        MessageDTO dto = new MessageDTO(1L, username, content, radius, duration);

        Message message= messageMapper.fromDTO(dto);

        Assert.assertEquals(dto.getUsername(),message.getUsername());
        Assert.assertEquals(dto.getContent(),message.getContent());
        Assert.assertEquals(dto.getRadius(),message.getRadius());
        Assert.assertEquals(dto.getDuration(),message.getDuration());


    }

    @Test
    public void testFromDTO1() throws Exception {
        List<MessageDTO> messageDTOs = new ArrayList<>();

        String username="testUser";
        String content="Hello";
        Double radius=100.00;
        int duration= 10;
        MessageDTO dto = new MessageDTO(1L, username, content, radius, duration);
        String username1="testUser1";
        String content1="Hello1";
        Double radius1=1000.00;
        int duration1= 100;

        MessageDTO dto1 = new MessageDTO(2L, username1, content1, radius1, duration1);

        messageDTOs.add(dto);
        messageDTOs.add(dto1);

        List<Message> messages=messageMapper.fromDTO(messageDTOs);
        Assert.assertEquals(messageDTOs.get(0).getUsername(),messages.get(0).getUsername());
        Assert.assertEquals(messageDTOs.get(1).getUsername(),messages.get(1).getUsername());
        Assert.assertEquals(messageDTOs.get(1).getContent(),messages.get(1).getContent());
        Assert.assertEquals(messageDTOs.get(0).getRadius(),messages.get(0).getRadius());
        Assert.assertEquals(messageDTOs.get(1).getDuration(),messages.get(1).getDuration());



    }

    @Test
    public void testToDTO() throws Exception {
        Long id = 1L;
        String username="testUser";
        String content="Hello";
        Double radius=100.00;
        int duration= 10;
        Message message = new Message(username, content, radius, duration);
        message.setId(id);
        MessageDTO dto= messageMapper.toDTO(message);

        Assert.assertEquals(dto.getId(),message.getId());
        Assert.assertEquals(dto.getUsername(),message.getUsername());
        Assert.assertEquals(dto.getContent(),message.getContent());
        Assert.assertEquals(dto.getRadius(),message.getRadius());
        Assert.assertEquals(dto.getDuration(),message.getDuration());
    }

    @Test
    public void testToDTO1() throws Exception {
        Long id = 1L;
        String username="testUser";
        String content="Hello";
        Double radius=100.00;
        int duration= 10;
        Message message = new Message(username, content, radius, duration);
        message.setId(id);
        Long id1 = 2L;
        String username1="testUser1";
        String content1="Hello1";
        Double radius1=10000.00;
        int duration1= 100;
        Message message1 = new Message(username1, content1, radius1, duration1);
        message1.setId(id1);

        List<Message> messages=new ArrayList<>();
        messages.add(message);
        messages.add(message1);

        List<MessageDTO> messageDTOs= messageMapper.toDTO(messages);
        Assert.assertEquals(messageDTOs.get(0).getId(),messages.get(0).getId());
        Assert.assertEquals(messageDTOs.get(1).getId(),messages.get(1).getId());
        Assert.assertEquals(messageDTOs.get(0).getUsername(),messages.get(0).getUsername());
        Assert.assertEquals(messageDTOs.get(1).getUsername(),messages.get(1).getUsername());
        Assert.assertEquals(messageDTOs.get(1).getContent(),messages.get(1).getContent());
        Assert.assertEquals(messageDTOs.get(0).getRadius(),messages.get(0).getRadius());
        Assert.assertEquals(messageDTOs.get(1).getDuration(),messages.get(1).getDuration());

    }
}