package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.service.PathService;
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.UserPath;
import com.zjgsu.studyweb.service.PathService;
import io.swagger.models.auth.In;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;                                 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;                                                   
import java.util.List;


@RestController
public class PathController {

    @Autowired
    private PathService pathService;

    @RequestMapping(value = "/path/getHotPathList", method = RequestMethod.POST)
    List<Path> find(){
        return pathService.findHotPath();
    }

    @RequestMapping(value = "/path/getPathList", method = RequestMethod.POST)
    List<Path> findAll(){
        return pathService.findAll();
    }
    @RequestMapping(value = "/path",method = RequestMethod.GET)
    public List<Path> getAllPath(){
        return pathService.Ask_Path();
    }

    @RequestMapping(value = "/path/{id}",method = RequestMethod.GET)
    public List<Path> getPath(@PathVariable Long id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return pathService.getPath(id);
    }

    @RequestMapping(value = "/path",method = RequestMethod.POST)
    public UserPath addPath(@RequestBody UserPath userPath){
        if (pathService.addPath(userPath) == 1){
            return userPath;
        }else{
            return new UserPath();
        }
    }
    @RequestMapping(value = "/path/course/{id}",method = RequestMethod.GET)
    public Course getCourseInfo(@PathVariable Long id){
        return pathService.getCourseInfo(id);
    }

    @RequestMapping(value = "/getCourse/{path_id}",method = RequestMethod.GET)
    public List<Course> getCourseByPathId(@PathVariable Long path_id){
        return pathService.getCourseByPathId(path_id);
    }
}
