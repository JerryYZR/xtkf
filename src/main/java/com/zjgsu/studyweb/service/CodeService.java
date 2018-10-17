package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Code;
import com.zjgsu.studyweb.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {
    @Autowired
    CodeMapper codeMapper;

    public List<Code> getCode(long path_id){
        QueryWrapper<Code> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("path_id",path_id);
        return codeMapper.selectList(queryWrapper);
    }

}
