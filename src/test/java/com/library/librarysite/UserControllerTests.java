package com.library.librarysite;

/*import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.librarysite.Controllers.UserController;
import com.library.librarysite.Data.User;
import com.library.librarysite.Data.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        //Mock UserRepo Behavior
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User testUser = invocation.getArgument(0);
            testUser.setId(1);
            return testUser;
        });

        when(userRepository.findAll()).thenReturn(Arrays.asList(createTestUser()));
        when(userRepository.findUserById(1)).thenReturn(createTestUser());
    }

    @Test
    void testAddUser() throws Exception {
        User testUser = createTestUser();

        mockMvc.perform(post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("newFirst"))
                .andExpect(jsonPath("$.lastName").value("newLast"))
                .andExpect(jsonPath("$.email").value("newEmail"));
    }

    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/user/showall"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].firstName").value("newFirst"))
                .andExpect(jsonPath("$[0].lastName").value("newLast"))
                .andExpect(jsonPath("$[0].email").value("newEmail"));
    }

    @Test
    void testGetUser() throws Exception {
        mockMvc.perform(get("/user/get/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("newFirst"))
                .andExpect(jsonPath("$.lastName").value("newLast"))
                .andExpect(jsonPath("$.email").value("newEmail"));
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/user/delete/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted").value(true));
    }

    private User createTestUser() {
        return new User("newFirst", "newLast", "newEmail");
    }
}
*/