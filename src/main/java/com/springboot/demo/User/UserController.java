package com.springboot.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") UUID userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
    }

}
