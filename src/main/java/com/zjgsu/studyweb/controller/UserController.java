package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
