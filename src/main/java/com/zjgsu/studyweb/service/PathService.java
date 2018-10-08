package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Path;

import com.zjgsu.studyweb.mapper.PathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PathService {

    @Autowired
    PathMapper pathMapper;//这里标红的话不要管它..


    public List<Path> findAll() {
        return pathMapper.selectList(null);
    }

    public List<Path> findHotPath() {
        QueryWrapper<Path> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("heat");
        queryWrapper.last("limit 5");
        return pathMapper.selectList(queryWrapper);
    }
}
