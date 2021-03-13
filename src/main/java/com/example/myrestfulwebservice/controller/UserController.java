package com.example.myrestfulwebservice.controller;

import com.example.myrestfulwebservice.model.User;
import com.example.myrestfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable Long id) {
        User user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("id[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //savedUser 어떤 용도로 사용하기 위해 일단 저장
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userService.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("id[%s] not found", id));
        }

    }
}
