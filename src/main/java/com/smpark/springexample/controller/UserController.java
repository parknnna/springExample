package com.smpark.springexample.controller;

import com.smpark.springexample.entity.Users;
import com.smpark.springexample.rest.DataResponse;
import com.smpark.springexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers.do")
    public DataResponse<List<Users>> getUsers() {
        DataResponse<List<Users>> ret = new DataResponse<>();
        try {
            ret.setData(userService.getUsers());
        } catch (Exception e) {
            ret.setError("처리중 오류가 있습니다.", -1);
        }
        return ret;
    }

    @GetMapping("/getUsersById.do")
    public DataResponse<Users> getUsersById(@RequestParam long id) {
        DataResponse<Users> ret = new DataResponse<>();

        try {
            ret.setData(userService.getUser(id));
        } catch (Exception e) {
            ret.setError("처리중 오류가 있습니다.", -1);
        }

        return ret;
    }

    @PostMapping("/addUser.do")
    public DataResponse<Boolean> addUser(@RequestBody Users users) {
        DataResponse<Boolean> ret = new DataResponse<>();
        try {
            userService.addUser(users);
            ret.setData(true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setError("처리중 오류가 있습니다.", -1);
        }
        return ret;
    }

    @PutMapping("/modUser.do")
    public DataResponse<Boolean> modUser(@RequestBody Users users) {
        DataResponse<Boolean> ret = new DataResponse<>();

        try {
            userService.modUser(users);
            ret.setData(true);
        } catch(Exception e) {
            e.printStackTrace();
            ret.setError("처리중 오류가 있습니다.", -1);
        }

        return ret;
    }

    @DeleteMapping("/delUser.do")
    public DataResponse<Boolean> delUser(@RequestBody Users users) {
        DataResponse<Boolean> ret = new DataResponse<>();
        try {
            userService.delUser(users);
            ret.setData(true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setError("처리중 오류가 있습니다.", -1);
        }

        return ret;
    }

}
