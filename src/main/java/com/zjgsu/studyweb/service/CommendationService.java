<<<<<<< HEAD
package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Commendation;
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.mapper.CommendationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommendationService {
    @Autowired
    CommendationMapper commendationMapper;

    public List<Commendation> getCommendations(String type,Long foreign_id) {
        QueryWrapper<Commendation> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type",type).eq("foreign_id",foreign_id);
        return  commendationMapper.selectList(queryWrapper) ;
    }

    public Integer addCommendation(Commendation commendation) {
        return commendationMapper.insert(commendation);
    }


}
=======
package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Commendation;
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.mapper.CommendationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommendationService {
    @Autowired
    CommendationMapper commendationMapper;

    public List<Commendation> getCommendations(String type,Long foreign_id) {
        QueryWrapper<Commendation> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type",type).eq("foreign_id",foreign_id);
        return  commendationMapper.selectList(queryWrapper) ;
    }

    public Integer addCommendation(Commendation commendation) {
        return commendationMapper.insert(commendation);
    }


}
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
