package com.chataround.chataroundws;

/**
 * @author Georgia Grigoriadou
 */



        import com.chataround.chataroundws.controller.UserController;
        import com.chataround.chataroundws.model.DTO.UserDTO;
        import com.chataround.chataroundws.service.IUserService;

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
        import org.springframework.test.web.servlet.RequestBuilder;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;

        import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
        import static org.hamcrest.Matchers.*;

        import java.nio.charset.Charset;
        import java.util.ArrayList;
        import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private MediaType applicationJsonMediaType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {


        List<UserDTO> userDTOs = new ArrayList<>();

        UserDTO first = new UserDTO();


        first.setUsername("first");
        first.setLatitude(41.123456);
        first.setLongitude(20.98765);

        UserDTO second = new UserDTO();
        second.setUsername("second");
        second.setLatitude(41.123455);
        second.setLongitude(20.98760);

        UserDTO third = new UserDTO();
        third.setUsername("third");
        third.setLatitude(41.678765);
        third.setLongitude(21.4561239);

        userDTOs.add(first);
        userDTOs.add(second);


        String username="first";
        Double radius=10.000000;

        doReturn(userDTOs).when(userService).getInRadius(username,radius);
        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("id", username).param("radius", String.valueOf(radius)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].username").exists())
                .andExpect(jsonPath("$[*].latitude").exists())
                .andExpect(jsonPath("$[*].longitude").exists())
                .andExpect(jsonPath("$[0].username", is("first")))
                .andExpect(jsonPath("$[1].username", is("second")))
                .andExpect(jsonPath("$[0].latitude", is(41.123456)))
                .andExpect(jsonPath("$[0].longitude", is(20.98765)))
                .andExpect(jsonPath("$[1].latitude", is(41.123455)))
                .andExpect(jsonPath("$[1].longitude", is(20.98760)))
        ;

        verify(userService, times(1)).getInRadius(username,radius);

    }
}

