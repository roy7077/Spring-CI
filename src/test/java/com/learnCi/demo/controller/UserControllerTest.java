package com.learnCi.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnCi.demo.dto.User;
import com.learnCi.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Map;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSaveUser() throws Exception {
        User user = new User();
        user.setUserName("sagar");

        mockMvc.perform(post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("User Saved Successfully"));

        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    void testUserCount() throws Exception {
        when(userService.userCount("sagar")).thenReturn(3);

        mockMvc.perform(get("/api/v1/user/sagar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sagar").value(3));

        verify(userService, times(1)).userCount("sagar");
    }
}
