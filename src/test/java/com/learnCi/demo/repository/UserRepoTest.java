package com.learnCi.demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        userRepo = new UserRepo();
    }

    @Test
    void testUserCountWhenUserNotSaved() {
        int count = userRepo.userCount("sagar");
        assertEquals(0, count, "User count should be 0 when user not saved yet");
    }

    @Test
    void testSaveUserOnce() {
        userRepo.saveUser("sagar");
        int count = userRepo.userCount("sagar");
        assertEquals(1, count, "User count should be 1 after saving once");
    }

    @Test
    void testSaveUserMultipleTimes() {
        userRepo.saveUser("sagar");
        userRepo.saveUser("sagar");
        userRepo.saveUser("sagar");
        int count = userRepo.userCount("sagar");
        assertEquals(3, count, "User count should be 3 after saving three times");
    }

    @Test
    void testMultipleUsers() {
        userRepo.saveUser("sagar");
        userRepo.saveUser("raj");
        userRepo.saveUser("raj");

        assertEquals(1, userRepo.userCount("sagar"));
        assertEquals(2, userRepo.userCount("raj"));
        assertEquals(0, userRepo.userCount("unknown"));
    }
}
