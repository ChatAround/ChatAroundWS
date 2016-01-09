package com.chataround.chataroundws.TestService;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.exception.UserNotFoundException;
import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.MessageRepository;
import com.chataround.chataroundws.repository.UserRepository;
import com.chataround.chataroundws.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Gewrgia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class MessageServiceTest {

    private MockMvc mockMvc;


    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private IMapper<Message,MessageDTO> messageMapper;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(messageService).build();

    }


    @Test
    public void testAddMessageAndNotDeleteItSuccess() throws Exception{

        String username="test";
        String content="hello";
        Double radius=100.000;
        int duration=0;
        MessageDTO dto=new MessageDTO();
        dto.setUsername(username);
        dto.setContent(content);
        dto.setRadius(radius);
        dto.setDuration(duration);
        Message message=new Message(username,content,radius,duration);
        Mockito.when(userRepository.exists(username)).thenReturn(true);
        Mockito.when(messageMapper.fromDTO(dto)).thenReturn(message);


        messageService.addMessage(dto);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(messageRepository, VerificationModeFactory.times(1)).saveAndFlush(Mockito.any(Message.class));
        Mockito.verify(messageRepository, VerificationModeFactory.times(0)).delete(Mockito.anyLong());
        Mockito.reset(messageRepository);

    }
    @Test(expected = UserNotFoundException.class)
    public void testAddMessageAndNotDeleteItFail() throws Exception{

        String username="test";
        String content="hello";
        Double radius=100.000;
        int duration=0;
        MessageDTO dto=new MessageDTO();
        dto.setUsername(username);
        dto.setContent(content);
        dto.setRadius(radius);
        dto.setDuration(duration);
        Message message=new Message(username,content,radius,duration);
        Mockito.when(userRepository.exists(username)).thenReturn(false);
        Mockito.when(messageMapper.fromDTO(dto)).thenReturn(message);


        messageService.addMessage(dto);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(messageRepository, VerificationModeFactory.times(0)).saveAndFlush(Mockito.any(Message.class));
        Mockito.verify(messageRepository, VerificationModeFactory.times(0)).delete(Mockito.anyLong());
        Mockito.reset(messageRepository);

    }

    @Test
    public void testGetMessagesSuccess() throws Exception{

        String username="test";

        Message message1=new Message("Maria","hello",100.000,120);
        message1.setId(1L);
        Message message2=new Message("Eleni","hi",50.000,60);
        message1.setId(2L);
        List<Message> messages=new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        MessageDTO dto1=new MessageDTO(1L,"Maria","hello",100.000,120);
        MessageDTO dto2=new MessageDTO(2L,"Eleni","hi",50.000,60);
        List<MessageDTO> messageDTOs = new ArrayList<>();
        messageDTOs.add(dto1);
        messageDTOs.add(dto2);

        Mockito.when(userRepository.exists(username)).thenReturn(true);
        Mockito.when(messageRepository.findByUsername(username)).thenReturn(messages);
        Mockito.when(messageMapper.toDTO(messages)).thenReturn(messageDTOs);

        List<MessageDTO> response=messageService.getMessages(username);
        assertEquals(response,messageDTOs);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(messageRepository, VerificationModeFactory.times(1)).findByUsername(Mockito.anyString());
        Mockito.reset(messageRepository);
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetMessagesFail() throws Exception{

        String username="test";

        Message message1=new Message("Maria","hello",100.000,120);
        message1.setId(1L);
        Message message2=new Message("Eleni","hi",50.000,60);
        message1.setId(2L);
        List<Message> messages=new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        MessageDTO dto1=new MessageDTO(1L,"Maria","hello",100.000,120);
        MessageDTO dto2=new MessageDTO(2L,"Eleni","hi",50.000,60);
        List<MessageDTO> messageDTOs = new ArrayList<>();
        messageDTOs.add(dto1);
        messageDTOs.add(dto2);

        Mockito.when(userRepository.exists(username)).thenReturn(false);
        Mockito.when(messageRepository.findByUsername(username)).thenReturn(messages);
        Mockito.when(messageMapper.toDTO(messages)).thenReturn(messageDTOs);

        List<MessageDTO> response=messageService.getMessages(username);

        Mockito.verify(userRepository, VerificationModeFactory.times(1)).exists(Mockito.anyString());
        Mockito.verify(messageRepository, VerificationModeFactory.times(0)).findByUsername(Mockito.anyString());
        Mockito.reset(messageRepository);
    }


}
