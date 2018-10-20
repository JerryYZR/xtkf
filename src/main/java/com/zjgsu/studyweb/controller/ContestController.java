package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Contest;
import com.zjgsu.studyweb.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContestController {
    @Autowired
    ContestService contestService;

    @RequestMapping(value = "/contest/{degree}/{path_id}",method = RequestMethod.GET)
    public List<Contest> getContest(@PathVariable long path_id, @PathVariable Integer degree){
        return contestService.getContest(path_id,degree);
    }

}
