package com.eagle.Event.service;

import com.eagle.Event.dto.UserDto;
import com.eagle.Event.model.User;
import com.eagle.Event.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User saveUserSimple(User user){
//        User user1 = userRepository.save(user);
        return userRepository.save(user);
    }

    public User updateUser(UserDto personDto){
        User person = modelMapper.map(personDto, User.class);
        return userRepository.save(person);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


//    public List<User> getAllUser() {
//        return userRepository.findAll();
//    }
//
//    public Iterable<User> listUser() {
//        return userRepository.findAll();
//    }

//    public Optional<User> getUser(final Long id) {
//        return userRepository.findById(id);
//    }

/*    public User updateUser(UserDto personDto, Long id){
        Optional<User> userOptional = userRepository.findById(id);
        User person = modelMapper.map(personDto, User.class);
        return userRepository.save(person);
    }*/


//    public void adminDeleteUser(Long id){
//        userRepository.deleteById(id);
//    }

}
