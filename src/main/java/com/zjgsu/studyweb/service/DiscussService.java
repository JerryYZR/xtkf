package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Discuss;
import com.zjgsu.studyweb.entity.DiscussTutor;
import com.zjgsu.studyweb.entity.DiscussUser;
import com.zjgsu.studyweb.mapper.DiscussMapper;
import com.zjgsu.studyweb.mapper.DiscussTutorMapper;
import com.zjgsu.studyweb.mapper.DiscussUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussService {

    @Autowired
    DiscussMapper discussMapper;
    @Autowired
    DiscussUserMapper discussUserMapper;
    @Autowired
    DiscussTutorMapper discussTutorMapper;

    public List<Discuss> getAllDiscusses() {
        return discussMapper.selectList(null);
    }

    public Discuss getDiscussById(long id) {
        QueryWrapper<Discuss> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return discussMapper.selectOne(queryWrapper);
    }

    public List<Discuss> getDiscussesByUserId(Long userId) {
        List<DiscussUser> discussesIdList = new ArrayList<>();
        QueryWrapper<DiscussUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        discussesIdList = discussUserMapper.selectList(queryWrapper);

        List<Discuss> discussesList = new ArrayList<>();
        for (DiscussUser discussUser : discussesIdList) {
            QueryWrapper<Discuss> queryWrapper_discuss = new QueryWrapper<>();
            queryWrapper_discuss.eq("id", discussUser.getDiscussId());
            discussesList.add(discussMapper.selectOne(queryWrapper_discuss));
        }

        return discussesList;
    }

    public List<Discuss> getDiscussesByTutorId(Long userId) {
        List<DiscussTutor> discussesIdList = new ArrayList<>();
        QueryWrapper<DiscussTutor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tutor_id", userId);
        discussesIdList = discussTutorMapper.selectList(queryWrapper);

        List<Discuss> discussesList = new ArrayList<>();
        for (DiscussTutor discussTutor : discussesIdList) {
            QueryWrapper<Discuss> queryWrapper_discuss = new QueryWrapper<>();
            queryWrapper_discuss.eq("id", discussTutor.getDiscuss_id());
            discussesList.add(discussMapper.selectOne(queryWrapper_discuss));
        }

        return discussesList;
    }

    public Integer getDiscussesNumberByUserId(Long userId) {

        List<Discuss> discussesList = getDiscussesByUserId(userId);

        return discussesList.size();
    }

    public List<Discuss> getDiscussesByCreateUserId(Long create_userId) {
        List<Discuss> discussesList = new ArrayList<>();
        QueryWrapper<Discuss> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_userId", create_userId);
        discussesList = discussMapper.selectList(queryWrapper);

        return discussesList;
    }

    public Integer addDiscuss(Discuss discuss) {
        return discussMapper.insert(discuss);
    }

    public Integer updateDiscuss(Discuss discuss) {
        return discussMapper.updateById(discuss);
    }

    public Integer deleteDiscussById(long id) {
        return discussMapper.deleteById(id);
    }

    public List<Discuss> getHotDiscuss() {
        QueryWrapper<Discuss> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("heat");
        queryWrapper.last("limit 8");
        return discussMapper.selectList(queryWrapper);
    }

    public DiscussUser findbydid(Integer did) {
        QueryWrapper<DiscussUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.last("and discussId = "+did);
        return discussUserMapper.selectOne(queryWrapper);
    }
}
