package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.config.SHA1;
import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.zjgsu.studyweb.config.SHA1.encode;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;//这里标红的话不要管它..




    public List<User> getAllUserInfo() {
        return userMapper.selectList(null);
    }

    public User getUserInfoById(long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return userMapper.selectOne(wrapper);
    }

    public Integer addUser(User discuss) {
        return userMapper.insert(discuss);
    }

    public Integer updateUser(User discuss) {
        return userMapper.updateById(discuss);
    }

    public Integer deleteUserById(long id) {
        return userMapper.deleteById(id);
    }

    public Integer saveUser(String username, String password, String email) {
        SHA1 sha1=new SHA1();
        String passwordSHA1=encode(password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordSHA1);
        user.setEmail(email);
        return userMapper.insert(user);
    }

    public User findUser(String username, String password) {
        SHA1 sha1=new SHA1();
        String passwordSHA1=encode(password);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password",passwordSHA1);
        return userMapper.selectOne(wrapper);
    }
}
