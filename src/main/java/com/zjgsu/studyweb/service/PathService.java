package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.UserPath;
import com.zjgsu.studyweb.mapper.CourseMapper;
import com.zjgsu.studyweb.mapper.PathMapper;
import com.zjgsu.studyweb.mapper.PathUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PathService {

    @Autowired
    PathMapper pathMapper;
    @Autowired
    PathUserMapper pathUserMapper;
    @Autowired
    CourseMapper courseMapper;

    //查询全部的path
    public List<Path> Ask_Path() {
        return pathMapper.selectList(null);
    }

    //在PathUser表中插入一条数据
    public Integer addPath(UserPath userPath) {
        Long pathId = userPath.getPathid();
        Path path =  getPathById(pathId);
        if(path != null){
            int head = path.getHeat();
            head = head + 1;
            path.setHeat(head);
            updatePath(path);
        }
        return pathUserMapper.insert(userPath);
    }


    public List<Path> findAll() {
        return pathMapper.selectList(null);
    }

    //通过id查找path并返回学习人数
    public List<Path> getPath(long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Path> list = new ArrayList<>();
        Path path = getPathById(id);
        //Integer studyNum = getStudyNum(id);
        list.add(path);
        Class<?> clz = list.getClass();
        //Method method = clz.getMethod("add",Object.class);
        //method.invoke(list,studyNum);
        return list;
    }

    //获取学习人数
    public Integer getStudyNum(long path_id){
        QueryWrapper<UserPath> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pathid", path_id);
        List<UserPath> list = pathUserMapper.selectList(queryWrapper);
        return list.size();
    }


    //通过id查找path
    public Path getPathById(long id){
        QueryWrapper<Path> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return  pathMapper.selectOne(queryWrapper);
    }


    //更新Path
    public Integer updatePath(Path path){
        return pathMapper.updateById(path);
    }

    //通过课程id获取课程
    public Course getCourseInfo(long id){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return courseMapper.selectOne(queryWrapper);
    }
    //通过path_id获取课程id，name
    public List<Course> getCourseByPathId(long path_id){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("path_id",path_id);
        return courseMapper.selectList(queryWrapper);
    }

    public List<Path> findHotPath() {
        QueryWrapper<Path> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("heat");
        queryWrapper.last("limit 5");
        return pathMapper.selectList(queryWrapper);
    }

    public List<Path> findPathByKey(String key) {
        QueryWrapper<Path> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name",key);
        List<Path> paths=pathMapper.selectList(queryWrapper);
        if(paths.size()==0){
            paths=pathMapper.selectList(null);
        }
        return paths;
    }
}
