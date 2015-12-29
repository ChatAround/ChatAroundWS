package com.chataround.chataroundws.TestController;

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.controller.MessageController;
import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.service.IMessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Gewrgia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class MessageControllerTest {
    @Mock
    private IMessageService messageService;

    @InjectMocks
    private MessageController messageController;

    private MockMvc mockMvc;

    private MediaType applicationJsonMediaType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    public void testGetMessages() throws Exception {


        List<MessageDTO> messageDTOs = new ArrayList<>();

        MessageDTO message1 = new MessageDTO(
                1L,
                "testUser1",
                "Hello",
                100.000,
                10
        );

        MessageDTO message2 = new MessageDTO(
                2L,
                "testUser2",
                "Hi",
                100.000,
                10
        );
        MessageDTO message3 = new MessageDTO(
                3L,
                "testUser3",
                "Bye",
                100.000,
                10
        );


        messageDTOs.add(message1);
        messageDTOs.add(message2);
        messageDTOs.add(message3);

        String username="testUser1";

        doReturn(messageDTOs).when(messageService).getMessages(username);
        mockMvc.perform(get("/message").accept(MediaType.APPLICATION_JSON)
                .param("username", username))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[*].id").exists())
                .andExpect(jsonPath("$[*].username").exists())
                .andExpect(jsonPath("$[*].content").exists())
                .andExpect(jsonPath("$[*].radius").exists())
                .andExpect(jsonPath("$[*].duration").exists())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].username", is("testUser1")))
                .andExpect(jsonPath("$[1].username", is("testUser2")))
                .andExpect(jsonPath("$[2].username", is("testUser3")))
                .andExpect(jsonPath("$[0].content", is("Hello")))
                .andExpect(jsonPath("$[1].content", is("Hi")))
                .andExpect(jsonPath("$[2].content", is("Bye")))
                .andExpect(jsonPath("$[0].radius", is(100.000)))
                .andExpect(jsonPath("$[1].radius", is(100.000)))
                .andExpect(jsonPath("$[2].radius", is(100.000)))
                .andExpect(jsonPath("$[0].duration", is(10)))
                .andExpect(jsonPath("$[1].duration", is(10)))
                .andExpect(jsonPath("$[2].duration", is(10)))


        ;

        verify(messageService, times(1)).getMessages(username);

    }
}
