package com.chataround.chataroundws.TestController;

/**
 * @author Gewrgia
 */

import com.chataround.chataroundws.Application;
import com.chataround.chataroundws.controller.UserProfileController;
import com.chataround.chataroundws.model.DTO.UserProfileDTO;
import com.chataround.chataroundws.service.IUserProfileService;
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
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserProfileControllerTest {


    @Mock
    private IUserProfileService userProfileService;

    @InjectMocks
    private UserProfileController userProfileController;

    private MockMvc mockMvc;

    private MediaType applicationJsonMediaType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userProfileController).build();
    }

    @Test
    public void testGetUserProfile() throws Exception {

        String username="testUser";
        String firstName="Testa";
        String surName="Testidou";
        String gender="female";
        String country="Greece";
        String city="Serres";
        Date birthday=null ;
        String about=null;

        UserProfileDTO dto = new UserProfileDTO(
                username,
                firstName,
                surName,
                gender,
                country,
                city,
                birthday,
                about
        );


        doReturn(dto).when(userProfileService).getUserProfile(username);
        mockMvc.perform(get("/userProfile").accept(MediaType.APPLICATION_JSON)
                .param("username", username))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.surName").exists())
                .andExpect(jsonPath("$.gender").exists())
                .andExpect(jsonPath("$.country").exists())
                .andExpect(jsonPath("$.city").exists())
                .andExpect(jsonPath("$.birthday").doesNotExist())
                .andExpect(jsonPath("$.about").doesNotExist())
                .andExpect(jsonPath("$.username", is(username)))
                .andExpect(jsonPath("$.firstName", is(firstName)))
                .andExpect(jsonPath("$.surName", is(surName)))
                .andExpect(jsonPath("$.gender", is(gender)))
                .andExpect(jsonPath("$.country", is(country)))
                .andExpect(jsonPath("$.city", is(city)))
                .andExpect(jsonPath("$.birthday", is(birthday)))
                .andExpect(jsonPath("$.about", is(about)))

        ;

        verify(userProfileService, times(1)).getUserProfile(username);

    }


}

