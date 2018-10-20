package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Commendation;
import com.zjgsu.studyweb.service.CommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommendationController {
    @Autowired
    CommendationService commendationService;

    @RequestMapping(value = "/commendations/{type}/{foreign_id}",method = RequestMethod.GET)
    public List<Commendation> getCommendations(@PathVariable String type,@PathVariable Long foreign_id){
        return commendationService.getCommendations(type,foreign_id);
    }

    @RequestMapping(value = "/commendation",method = RequestMethod.POST)
    public  Commendation addCommendation(@RequestBody Commendation commendation){
        commendation.setCreate_time(LocalDateTime.now());
        if (commendationService.addCommendation(commendation) == 1) {
            return commendation;
        } else {
            return new Commendation();
        }
    }
}
