package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUserIfo() {
        return userService.getAllUserInfo();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User getUserIfoById(@RequestParam long id) {
        return userService.getUserInfoById(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addDiscuss(@RequestBody User user) {
        if (userService.addUser(user) == 1) {
            return user;
        } else {
            return new User();
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return user;
        } else {
            return new User();
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUserById(@RequestParam long id) {
        if (userService.deleteUserById(id) == 1) {
            return "{\"status\":\"success\"}";
        }else {
            return "{\"status\":\"fail\"}";
        }
    }
}
