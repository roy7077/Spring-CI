package com.learnCi.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepo {
    HashMap<String,Integer> mp = new HashMap<>();

    public void saveUser(String str) {
        mp.put(str, mp.getOrDefault(str, 0) + 1);
    }

    public int userCount(String str) {
        return this.mp.getOrDefault(str, 0);
    }
}
