package com.learnCi.demo.service;

import com.learnCi.demo.dto.User;
import com.learnCi.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(User user){
        this.userRepo.saveUser(user.getUserName());
    }

    public int userCount(String user){
        return this.userRepo.userCount(user);
    }
}
