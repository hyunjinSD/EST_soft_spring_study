package com.estsoft.springdemoproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/")
    public Object getAllUsers() {
        return userService.getAllUsers();
    }
}
