package com.eagle.Event.ServiceTest;

import com.eagle.Event.dto.UserDto;
import com.eagle.Event.model.User;
import com.eagle.Event.repository.UserRepository;
import com.eagle.Event.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void addUser(){
        User userNew = new User();
        userNew.setBirthday(new Date());
//        userNew.setFirstName("farima");
        userNew.setEmail("farima@mail");
        userNew.setLastName("farima");
        userNew.setPhone("123456789");
        userService.saveUserSimple(userNew);
        Assert.assertEquals(1, userNew.getId().longValue());
    }

    @Test
    @Order(2)
    void getUser(){
//        User userNew = new User();
//        userNew.setBirthday(new Date());
//        userNew.setFirstName("username");
//        userNew.setEmail("email@mail");
//        userNew.setLastName("pre");
//        userNew.setPhone("azerty");
//        userService.saveUserSimple(userNew);
        Optional<User> user = userService.getUserById(1l);
        Assert.assertEquals(1, user.get().getId().longValue());
    }

    @Test
    @Order(3)
    void getAllUsers(){
//        userService.saveUserSimple(userNew);
        List<User> users = userService.getAllUsers();
        int size = 1;
        Assert.assertEquals(users.size(), size);
    }

    @Test
    @Order(3)
    void putUser(){
        UserDto userDto = new UserDto();
        userDto.setEmail("er@er");
        userDto.setBirthday(new Date());
        userDto.setLastName("azert");
        userDto.setPhone("azert");
//        userDto.setFirstName("azert");
        userService.updateUser(userDto);
        userDto.setEmail("sira@fghj");
        userService.updateUser(userDto);
        System.out.println(userDto);
        Assert.assertEquals(userDto.getEmail(), "sira@fghj");
    }

    @Test
    void deleteUser(){
        User userNew = new User();
        userNew.setBirthday(new Date());
//        userNew.setFirstName("farima");
        userNew.setEmail("farima@mail");
        userNew.setLastName("farima");
        userNew.setPhone("123456789");
        userService.saveUserSimple(userNew);
        List<User> users = userService.getAllUsers();
        userService.deleteUser(userNew.getId());
        List<User> userFinal = userService.getAllUsers();
        Assert.assertEquals(userFinal.size(), 3);

    }
}
