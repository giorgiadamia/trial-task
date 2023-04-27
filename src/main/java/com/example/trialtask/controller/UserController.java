package com.example.trialtask.controller;

import com.example.trialtask.model.domain.User;
import com.example.trialtask.model.dto.UserDto;
import com.example.trialtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping("/update")
    public void updateName(@AuthenticationPrincipal User user, @RequestBody UserDto userDto) {
        userService.updateName(user, userDto);
    }

    @GetMapping
    public UserDto showUser(@AuthenticationPrincipal User user) {
        return userService.showUser(user);
    }

    @DeleteMapping
    public void deleteUser(@AuthenticationPrincipal User user) {
        userService.deleteUser(user);
    }
}
