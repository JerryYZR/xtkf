package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.msg.ResponseData;
import com.zjgsu.studyweb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        if (courseService.addCourse(course) == 1) {
            return course;
        } else {
            return new Course();
        }
    }

    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
    public Course updateCourse(@RequestBody Course course) {
        if (courseService.updateCourse(course) == 1) {
            return course;
        } else {
            return new Course();
        }
    }

    @RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
    public ResponseData deleteCourseById(@RequestParam long id) {
        if (courseService.deleteCourseById(id) == 1) {
            return new ResponseData(200,"OK",null);
        }else {
            return new ResponseData(1000,"no user",null);
        }
    }

    @RequestMapping(value = "/course/getHotCourseList", method = RequestMethod.POST)
    List<Course> find(){
        return courseService.findHotCourse();
    }
}
