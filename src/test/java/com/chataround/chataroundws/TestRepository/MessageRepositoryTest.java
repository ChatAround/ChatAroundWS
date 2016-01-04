package com.chataround.chataroundws.TestRepository;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.MessageRepository;
import com.chataround.chataroundws.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gewrgia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindOneSuccess() throws Exception{
        Long id=1l;
        Double radius=100.000;
        Message message=messageRepository.findOne(id);

        Assert.assertNotNull(message);
        Assert.assertEquals(id,message.getId());
        Assert.assertEquals("hi",message.getContent());
        Assert.assertEquals("Maria",message.getUsername());
        Assert.assertEquals(radius,message.getRadius());
        Assert.assertEquals(60,message.getDuration());

    }

    @Test
    public void testFindOneFail() throws Exception{
        Message message=messageRepository.findOne(5L);
        Assert.assertNull(message);
    }

    @Transactional
    @Test
    public void testAddMessage() throws Exception{
        Long id=5L;

        String username="Maria";
        String content="hello world";
        Double radius= 50.000;
        int duration=120;

        Message message=new Message(username,content,radius,duration);
        messageRepository.saveAndFlush(message);

        Message added=messageRepository.findOne(id);
        Assert.assertNotNull(added);
        Assert.assertEquals(id,message.getId());
        Assert.assertEquals(content,message.getContent());
        Assert.assertEquals(username,message.getUsername());
        Assert.assertEquals(radius,message.getRadius());
        Assert.assertEquals(duration,message.getDuration());

        messageRepository.delete(id);
    }

    @Transactional
    @Test
    public void testDeleteMessage() throws Exception{

        Long id=6L;

        String username="Maria";
        String content="hello world";
        Double radius= 50.000;
        int duration=120;

        Message message=new Message(username,content,radius,duration);
        messageRepository.saveAndFlush(message);

        Message added=messageRepository.findOne(id);
        Assert.assertNotNull(added);
        Assert.assertEquals(id,message.getId());
        Assert.assertEquals(content,message.getContent());
        Assert.assertEquals(username,message.getUsername());
        Assert.assertEquals(radius,message.getRadius());
        Assert.assertEquals(duration,message.getDuration());

        messageRepository.delete(id);

        Message deleted=messageRepository.findOne(id);

        Assert.assertNull(deleted);

    }

    @Test
    public void testGetMessagesByUserName() throws Exception {

        List<Message> messages=messageRepository.findByUsername("Maria");

        Long id=1L;
        Long id1=2L;
        Double radius=100.000;
        Double radius1=10000.000;
        int duration=60;

        Assert.assertNotNull(messages);
        Assert.assertEquals(2,messages.size());
        Assert.assertEquals(id,messages.get(0).getId());
        Assert.assertEquals(id1,messages.get(1).getId());
        Assert.assertEquals("Maria",messages.get(0).getUsername());
        Assert.assertEquals("Eleni",messages.get(1).getUsername());
        Assert.assertEquals("hi",messages.get(0).getContent());
        Assert.assertEquals("alex",messages.get(1).getContent());
        Assert.assertEquals(radius,messages.get(0).getRadius());
        Assert.assertEquals(radius1,messages.get(1).getRadius());
        Assert.assertEquals(duration,messages.get(0).getDuration());
        Assert.assertEquals(duration,messages.get(1).getDuration());




    }

}


