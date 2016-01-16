package com.chataround.chataroundws.TestController;

/**
 * @author Georgia Grigoriadou
 */



        import com.chataround.chataroundws.Application;
        import com.chataround.chataroundws.controller.UserController;
        import com.chataround.chataroundws.model.DTO.UserDTO;
        import com.chataround.chataroundws.service.IUserService;

        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.*;
        import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
        import org.springframework.boot.test.SpringApplicationContextLoader;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;
        import org.springframework.validation.BindException;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    public void testGetUsersInRadiusSuccess() throws Exception {


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
                .param("username", username).param("radius", String.valueOf(radius)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].username").exists())
                .andExpect(jsonPath("$[*].latitude").exists())
                .andExpect(jsonPath("$[*].longitude").exists())
                .andExpect(jsonPath("$[*].password").exists())
                .andExpect(jsonPath("$[0].username", is("first")))
                .andExpect(jsonPath("$[1].username", is("second")))
                .andExpect(jsonPath("$[0].latitude", is(41.123456)))
                .andExpect(jsonPath("$[0].longitude", is(20.98765)))
                .andExpect(jsonPath("$[1].latitude", is(41.123455)))
                .andExpect(jsonPath("$[1].longitude", is(20.98760)))
                .andExpect(jsonPath("$[0].password", is(nullValue())))
                .andExpect(jsonPath("$[1].password", is(nullValue())))

        ;

        verify(userService, times(1)).getInRadius(username,radius);

    }



    @Test(expected= AssertionError.class)
    public void testGetUsersInRadiusFailNullUsername() throws Exception {

        String username=null;
        Double radius=20.000;



        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("username", username).param("radius", String.valueOf(radius)))

                .andExpect(status().is(500))


        ;

        verify(userService, times(0)).getInRadius(username,radius);

    }

    @Test(expected= AssertionError.class)
    public void testGetUsersInRadiusFailNullRadius() throws Exception {

        String username="test";
        Double radius=null;



        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("username", username).param("radius", String.valueOf(radius)))

                .andExpect(status().is(500))


        ;

        verify(userService, times(0)).getInRadius(username,radius);

    }

    @Test(expected= AssertionError.class)
    public void testGetUsersInRadiusFailMissingUsername() throws Exception {

        String username="test";

        Double radius=20.000;


        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("radius", String.valueOf(radius)))

                .andExpect(status().is(500))

        ;
        verify(userService, times(0)).getInRadius(username,radius);


    }

    @Test(expected= AssertionError.class)
    public void  testGetUsersInRadiusFailMissingRadius()throws Exception {

        String username=null;

        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("username", username))
                .andExpect(status().is(500))

        ;
        verify(userService, times(0)).getInRadius(username,Mockito.anyDouble());

    }

    @Test(expected= InvalidUseOfMatchersException.class)
    public void testGetUsersInRadiusFailWrongTypeofRadius() throws Exception {

        String username="test";
        String radius="test";

        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)
                .param("username", username).param("radius",radius))
                .andExpect(status().is(400))

        ;
        verify(userService, times(0)).getInRadius(username, Mockito.anyDouble());

    }


    @Test
    public void testGetUserSuccess() throws Exception {
        UserDTO dto = new UserDTO();
        String username="testUser";

        dto.setUsername(username);
        dto.setLatitude(41.123456);
        dto.setLongitude(20.98765);
        dto.setOnline(true);

        doReturn(dto).when(userService).getUser(username);
        mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON)
                .param("username", username))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))

                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.latitude").exists())
                .andExpect(jsonPath("$.longitude").exists())
                .andExpect(jsonPath("$.password").doesNotExist())
                .andExpect(jsonPath("$.username", is(username)))
                .andExpect(jsonPath("$.latitude", is(41.123456)))
                .andExpect(jsonPath("$.longitude", is(20.98765)))

        ;

        verify(userService, times(1)).getUser(username);

    }

    @Test
    public void testGetUserFailNullUsername() throws Exception {
                String username=null;

                mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON)
                .param("username", username))
                .andExpect(status().is(400))

        ;
        verify(userService, times(0)).getUser(username);

    }

    @Test
    public void testGetUserFailMissingParam() throws Exception {

        mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))

        ;
        verify(userService, times(0)).getUser(anyString());

    }

    @Test
    public void testAddUserSuccess() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=41.123456;
        Double longitude=22.122345;
        Boolean isOnline=true;

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().isOk())
                ;
        ArgumentCaptor<UserDTO> formObjectArgument = ArgumentCaptor.forClass(UserDTO.class);
        verify(userService, times(1)).addUser(formObjectArgument.capture());
        verifyNoMoreInteractions(userService);

        UserDTO formObject = formObjectArgument.getValue();

        assertThat(formObject.getUsername(), is(username));
        assertThat(formObject.getPassword(), is(password));
        assertThat(formObject.getLatitude(), is(latitude));
        assertThat(formObject.getLongitude(), is(longitude));


    }

    @Test
    public void testAddUserFailNullParam() throws Exception {
        String username=null;
        String password="12345";
        Double latitude=41.123456;
        Double longitude=22.122345;
        Boolean isOnline=true;

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).addUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testAddUserFailMissingParam() throws Exception {
        String password="12345";
        Double latitude=41.123456;
        Double longitude=22.122345;
        Boolean isOnline=true;

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).addUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testAddUserFailWrongTypeofParam() throws Exception {
        String username="test";
        String password="12345";
        String latitude="testos";
        Double longitude=22.122345;
        Boolean isOnline=true;

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username",username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).addUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testAddUserFailUsernameSmallerThanMin() throws Exception {
        String username="te";
        String password="12345";
        Double latitude=41.123456;
        Double longitude=22.122345;
        Boolean isOnline=true;

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username",username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;
        verify(userService, times(0)).addUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testAddUserFailUsernameBiggerThanMax() throws Exception {
        String username="test1234567890123456789";
        String password="12345";
        Double latitude=41.123456;
        Double longitude=22.122345;
        Boolean isOnline=true;
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username",username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).addUser(Mockito.any(UserDTO.class));

    }
    @Test
    public void testUpdateUserSuccess() throws Exception {
        String username="test";
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;

        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().isOk())
        ;
        ArgumentCaptor<UserDTO> formObjectArgument = ArgumentCaptor.forClass(UserDTO.class);
        verify(userService, times(1)).updateUser(formObjectArgument.capture());
        verifyNoMoreInteractions(userService);

        UserDTO formObject = formObjectArgument.getValue();

        assertThat(formObject.getUsername(), is(username));
        assertThat(formObject.getPassword(), is(password));
        assertThat(formObject.getLatitude(), is(latitude));
        assertThat(formObject.getLongitude(), is(longitude));
    }

    @Test
    public void testUpdateUserFailNullParam() throws Exception {
        String username=null;
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;

        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;
        verify(userService, times(0)).updateUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testUpdateUserFailMissingParam() throws Exception {
        String password="12345";
        Double latitude=41.987654;
        Double longitude=22.8765432;
        Boolean isOnline=true;

        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("password", password)
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;
        verify(userService, times(0)).updateUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testUpdateUserFailWrongTypeofParam() throws Exception {
        String username="test";
        String password="12345";
        String latitude="testis";
        Double longitude=22.8765432;
        Boolean isOnline=true;

        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username)
                .param("password", password)
                .param("latitude", latitude)
                .param("longitude", String.valueOf(longitude))
                .param("isOnline", String.valueOf(isOnline)))
                .andExpect(status().is(400))
        ;
        verify(userService, times(0)).updateUser(Mockito.any(UserDTO.class));

    }

    @Test
    public void testDeleteUserSuccess() throws Exception {
        String username="test";

        mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username))
                .andExpect(status().isOk())
                ;
        verify(userService, times(1)).deleteUser(username);

    }

    @Test
    public void testDeleteUserFailNullUsername() throws Exception {
        String username=null;

        mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", username))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).deleteUser(username);

    }

    @Test
    public void testDeleteUserFailMissingParam() throws Exception {

        mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is(400))
        ;

        verify(userService, times(0)).deleteUser(anyString());

    }
}

