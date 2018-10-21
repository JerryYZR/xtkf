package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.entity.UserTutor;
import com.zjgsu.studyweb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        User user = userService.getUserInfoById(id);
        return user;
    }

    @RequestMapping(value = "/users/tutor/userId", method = RequestMethod.POST)
    public List<User> getTutorInfoByUserId(@RequestParam long id) {
        return userService.getTutorInfoByUserId(id);
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

    @RequestMapping(value = "/addTutorUser", method = RequestMethod.POST)
    public UserTutor addTutorUser(@RequestParam long userId, @RequestParam long tutorId) {
        UserTutor userTutor = new UserTutor();
        userTutor.setTutor_id(tutorId);
        userTutor.setUser_id(userId);
        if (userService.addTutorUser(userTutor) == 1) {
            return userTutor;
        } else {
            return new UserTutor();
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



    @ApiOperation(value="save", notes="用户注册",httpMethod = "POST")
    @ApiImplicitParams(value ={
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "email",value = "电子邮箱",dataType = "String",paramType = "query"),
    } )
    @RequestMapping("/user/save")
    Map<String,Object> saveUser(@RequestParam("username")String username,
                    @RequestParam("password")String password, @RequestParam("email")String email
                  ){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(userService.saveUser(username,password,email)==1) {
            resultMap.put("status", 200);
            resultMap.put("message", "注册成功");
        }
        else{
            resultMap.put("status", 500);
            resultMap.put("message", "注册失败");
        }
        return resultMap;
    }



    @ApiOperation(value="login", notes="用户登录",httpMethod = "POST")
    @ApiImplicitParams(value ={
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",paramType = "query"),
    } )
    @RequestMapping("/user/login")
    Map<String,Object> login(@RequestParam("username")String username,@RequestParam("password")String password){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        User u=userService.findUser(username,password);
        if(u!=null) {
            resultMap.put("user",u);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
        } else  {
            resultMap.put("status", 500);
            resultMap.put("message", "账号不存在");
        }
        return resultMap;
    }
}
