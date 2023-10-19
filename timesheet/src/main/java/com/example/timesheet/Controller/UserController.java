package com.example.timesheet.Controller;

import com.example.timesheet.Service.UserService;
import com.example.timesheet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> fetchUserList(){
        return userService.fetchUserList();
    }

    @PostMapping("/user")
    public User saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }
}
