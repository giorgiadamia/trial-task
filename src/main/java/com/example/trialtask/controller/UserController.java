package com.example.trialtask.controller;

import com.example.trialtask.model.domain.User;
import com.example.trialtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }
}
