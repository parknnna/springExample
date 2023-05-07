package com.smpark.springexample.service;

import com.smpark.springexample.entity.Users;
import com.smpark.springexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users getUser(long id) {
        return userRepository.findUsersById(id);
    }

    public void addUser(Users users) throws Exception {
        userRepository.save(users);
    }

    public void modUser(Users users) throws Exception {
        userRepository.save(users);
    }

    public void delUser(Users users) throws Exception {
        userRepository.delete(users);
    }

}
