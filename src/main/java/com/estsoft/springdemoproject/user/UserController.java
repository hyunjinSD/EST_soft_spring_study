package com.estsoft.springdemoproject.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Object getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @PatchMapping("/{id}")
    public void updateUserName(@PathVariable Long id, @RequestBody String name) {
        userService.updateUserName(id, name);
    }

    @GetMapping("/")
    public Object getAllUsers() {
        return userService.getAllUsers();
    }
}
