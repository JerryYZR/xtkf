package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
