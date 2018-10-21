package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.zjgsu.studyweb.config.SHA1;
import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.entity.UserTutor;
import com.zjgsu.studyweb.mapper.UserMapper;
import com.zjgsu.studyweb.mapper.UserTutorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.zjgsu.studyweb.config.SHA1.encode;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserTutorMapper userTutorMapper;

    public List<User> getAllUserInfo() {
        return userMapper.selectList(null);
    }

    public User getUserInfoById(long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return userMapper.selectOne(wrapper);
    }

    public List<User> getTutorInfoByUserId(long id) {
        List<UserTutor> questionsIdList = new ArrayList<>();
        QueryWrapper<UserTutor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        questionsIdList = userTutorMapper.selectList(queryWrapper);

        List<User> usersList = new ArrayList<>();
        for (UserTutor userTutor : questionsIdList) {
            QueryWrapper<User> queryWrapper_question = new QueryWrapper<>();
            queryWrapper_question.eq("id", userTutor.getTutor_id());
            usersList.add(userMapper.selectOne(queryWrapper_question));
        }

        return usersList;
    }

    public Integer addTutorUser(UserTutor discuss) {
        return userTutorMapper.insert(discuss);
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
