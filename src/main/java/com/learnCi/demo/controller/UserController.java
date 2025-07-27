package com.learnCi.demo.controller;

import com.learnCi.demo.dto.User;
import com.learnCi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User Saved Successfully");
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Map<String, Integer>> userCount(@PathVariable String userName) {
        Map<String, Integer> map = new HashMap<>();
        map.put(userName, userService.userCount(userName));
        return ResponseEntity.ok(map);
    }
}
