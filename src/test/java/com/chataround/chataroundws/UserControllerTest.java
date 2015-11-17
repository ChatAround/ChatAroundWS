package com.chataround.chataroundws;

/**
 * @author Georgia Grigoriadou
 */



        import com.chataround.chataroundws.controller.UserController;
        import com.chataround.chataroundws.mapper.IMapper;
        import com.chataround.chataroundws.mapper.UserMapper;
        import com.chataround.chataroundws.model.DTO.UserDTO;
        import com.chataround.chataroundws.model.entity.Coordinates;
        import com.chataround.chataroundws.model.entity.User;
        import com.chataround.chataroundws.service.IUserService;

        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.SpringApplicationContextLoader;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;
        import java.util.Arrays;

        import static org.hamcrest.Matchers.*;
        import static org.hamcrest.Matchers.is;
        import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

        import java.nio.charset.Charset;
        import java.util.ArrayList;
        import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,  loader = SpringApplicationContextLoader.class)
public class UserControllerTest{

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
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception{



        List<UserDTO> userDTOs =  new ArrayList<>();

        UserDTO first=new UserDTO();
        Coordinates f_coor=new Coordinates(41.123456,20.98765);
        first.setUsername("first");
        first.setCoordinates(f_coor);

        UserDTO second=new UserDTO();
        Coordinates s_coor=new Coordinates(41.678765,21.4561239);
        second.setUsername("second");
        second.setCoordinates(s_coor);

        userDTOs.add(first);
        userDTOs.add(second);

        doReturn(userDTOs).when(userService).getAll();
        mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
             ;

        verify(userService, times(1)).getAll();

    }



}
