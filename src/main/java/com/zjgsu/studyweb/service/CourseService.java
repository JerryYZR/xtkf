package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseService {

    @Autowired
    CourseMapper courseMapper;

    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }

    public Integer addCourse(Course course) {
        return courseMapper.insert(course);
    }

    public Integer updateCourse(Course course) {
        return courseMapper.updateById(course);
    }

    public Integer deleteCourseById(long id) {
        return courseMapper.deleteById(id);
    }

    public List<Course> findHotCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("heat");
        queryWrapper.last("limit 5");
        return courseMapper.selectList(queryWrapper);
    }
}
