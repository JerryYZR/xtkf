package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "UserController", description = "用户信息")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="获取所有用户信息", notes="获取所有用户信息接口")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUserIfo() {
        return userService.getAllUserInfo();
    }

    @ApiOperation(value="获取单个用户", notes="获取单个用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true ,dataType = "long"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User getUserIfoById(@RequestParam long id) {
        return userService.getUserInfoById(id);
    }

    @ApiOperation(value="添加用户", notes="添加用户接口")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addDiscuss(@RequestBody User user) {
        if (userService.addUser(user) == 1) {
            return user;
        } else {
            return new User();
        }
    }

    @ApiOperation(value="更新用户信息", notes="更新用户信息接口")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return user;
        } else {
            return new User();
        }
    }

    @ApiOperation(value="删除用户", notes="删除用户接口")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUserById(@RequestParam long id) {
        if (userService.deleteUserById(id) == 1) {
            return "{\"status\":\"success\"}";
        }else {
            return "{\"status\":\"fail\"}";
        }
    }
}
