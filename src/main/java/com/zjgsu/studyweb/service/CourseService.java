package com.zjgsu.studyweb.service;

import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
