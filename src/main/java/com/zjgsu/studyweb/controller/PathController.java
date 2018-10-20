package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.UserPath;
import com.zjgsu.studyweb.service.PathService;
<<<<<<< HEAD
import io.swagger.models.auth.In;
import org.omg.CORBA.PUBLIC_MEMBER;
=======
import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.UserPath;
import com.zjgsu.studyweb.service.PathService;
import io.swagger.models.auth.In;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;                                 
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import java.time.LocalDateTime;                                                   
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
import java.util.List;

@RestController
public class PathController {
    @Autowired
    PathService pathService;

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
<<<<<<< HEAD
=======
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
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
    @RequestMapping(value = "/path/course/{id}",method = RequestMethod.GET)
    public Course getCourseInfo(@PathVariable Long id){
        return pathService.getCourseInfo(id);
    }

    @RequestMapping(value = "/getCourse/{path_id}",method = RequestMethod.GET)
    public List<Course> getCourseByPathId(@PathVariable Long path_id){
        return pathService.getCourseByPathId(path_id);
    }
<<<<<<< HEAD

=======
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
}
