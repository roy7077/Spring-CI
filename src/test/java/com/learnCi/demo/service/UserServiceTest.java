package com.learnCi.demo.service;

import com.learnCi.demo.dto.User;
import com.learnCi.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepo userRepo;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepo = Mockito.mock(UserRepo.class);
        userService = new UserService();
        userService.userRepo = userRepo;  // Inject mock manually
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUserName("sagar");

        userService.saveUser(user);

        verify(userRepo, times(1)).saveUser("sagar");
    }

    @Test
    void testUserCount() {
        when(userRepo.userCount("raj")).thenReturn(5);

        int count = userService.userCount("raj");

        assertEquals(5, count);
        verify(userRepo, times(1)).userCount("raj");
    }
}
