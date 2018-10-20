package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Contest;
import com.zjgsu.studyweb.mapper.ContestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {
    @Autowired
    ContestMapper contestMapper;

    public List<Contest> getContest(long path_id, Integer degree){
        QueryWrapper<Contest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("path_id",path_id).eq("degree",degree);
        return contestMapper.selectList(queryWrapper);
    }

}
