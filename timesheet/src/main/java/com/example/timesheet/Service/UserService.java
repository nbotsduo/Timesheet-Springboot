package com.example.timesheet.Service;

import com.example.timesheet.entity.User;

import java.util.List;


public interface UserService {
    public User saveUser(User user);

    public List<User> fetchUserList();

    User fetchUserByName(String name);
}
