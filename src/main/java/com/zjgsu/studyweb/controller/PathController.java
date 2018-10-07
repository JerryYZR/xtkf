package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Path;
import com.zjgsu.studyweb.entity.User;
import com.zjgsu.studyweb.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
