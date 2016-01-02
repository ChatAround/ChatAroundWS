package com.chataround.chataroundws.TestService;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.MessageRepository;
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

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(messageService).build();

    }

    //Grapse ta test edo

}
