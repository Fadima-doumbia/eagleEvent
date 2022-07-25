package com.eagle.Event.controller;

import com.eagle.Event.dto.UserDto;
import com.eagle.Event.model.User;
import com.eagle.Event.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("api/events/users")
public class UserController {
    @Autowired
    UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();


    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUserSimple(user);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable("userId") final Long personId){
        return userService.getUserById(personId);
    }

    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/list")
    public Iterable<User> getAll(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void userDelete (@PathVariable("userId") final Long personId){
        userService.deleteUser(personId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("")
    public User updateUser(@RequestBody UserDto personDto){
        return userService.edit(personDto);
    }
}
