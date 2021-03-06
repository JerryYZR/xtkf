package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Course;
import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.UserPath;
import com.zjgsu.studyweb.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
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
    @RequestMapping(value = "/path/course/{id}",method = RequestMethod.GET)
    public Course getCourseInfo(@PathVariable Long id){
        return pathService.getCourseInfo(id);
    }

    @RequestMapping(value = "/getCourse/{path_id}",method = RequestMethod.GET)
    public List<Course> getCourseByPathId(@PathVariable Long path_id){
        return pathService.getCourseByPathId(path_id);
    }
    @RequestMapping(value = "/path/getHotPathList", method = RequestMethod.POST)
    List<Path> find(){
        return pathService.findHotPath();
    }

    @RequestMapping(value = "/path/getPathList", method = RequestMethod.POST)
    List<Path> findAll(){
        return pathService.findAll();
    }

    /**
     * 根据关键字搜索,若搜索内容为空，显示全部
     * @return
     */
    @RequestMapping(value = "/path_search/{key}",method = RequestMethod.GET)
    public List<Path> getPathByKey(@PathVariable String key){
        return pathService.findPathByKey(key);
    }

}
