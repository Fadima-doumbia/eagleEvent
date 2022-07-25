package com.eagle.Event.controller;

import com.eagle.Event.dto.UserDto;
import com.eagle.Event.dto.UserEditDto;
import com.eagle.Event.model.Event;
import com.eagle.Event.model.User;
import com.eagle.Event.repository.UserRepository;
import com.eagle.Event.service.EventService;
import com.eagle.Event.service.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("api/admin/users")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    EventService eventService;

    @DeleteMapping("/users/{userId}")
    public void userDelete (@PathVariable("userId") final Long personId){
        userService.deleteUser(personId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody UserEditDto personDto){
        User user= userRepository.findById(personDto.getId()).get();
        String password = encoder.encode(user.getPassword());
        personDto.setPassword(encoder.encode(personDto.getPassword()));
        if (password==personDto.getPassword()){
            return userService.editUser(personDto);
        }
        return null;
    }

    @PostMapping("/event/final")
    public Event saveEventFinal(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @PostMapping("/event")
    public Event saveEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

}
