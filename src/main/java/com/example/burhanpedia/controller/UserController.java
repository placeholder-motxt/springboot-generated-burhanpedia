package com.example.burhanpedia.controller;

import com.example.burhanpedia.model.User;
import com.example.burhanpedia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Create a new user")
    public User createUser(@RequestBody User user) {
        // Do not pass the id to create a user, it will be auto-generated
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user")
    public User updateUser(@RequestBody User user, @PathVariable String id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
