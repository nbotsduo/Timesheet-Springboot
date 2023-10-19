package com.example.timesheet.Service;

import com.example.timesheet.Repository.UserRepository;
import com.example.timesheet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserByName(String name) {
        return userRepository.findByName(name);
    }
}
