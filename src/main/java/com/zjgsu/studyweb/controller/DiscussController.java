package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Discuss;
import com.zjgsu.studyweb.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class DiscussController {

    @Autowired
    DiscussService discussService;

    @RequestMapping(value = "/discusses", method = RequestMethod.POST)
    public List<Discuss> getAllDiscusses() {
        return discussService.getAllDiscusses();
    }

    @RequestMapping(value = "/discuss", method = RequestMethod.POST)
    public Discuss getDiscusseById(@RequestParam long id) {
        return discussService.getDiscussById(id);
    }

    @RequestMapping(value = "/user/discusses", method = RequestMethod.POST)
    public List<Discuss> getDiscussesByUserId(@RequestParam long id) {
        return discussService.getDiscussesByUserId(id);
    }

    @RequestMapping(value = "/addDiscuss", method = RequestMethod.POST)
    public Discuss addDiscuss(@RequestBody Discuss discuss) {
        discuss.setCreate_time(LocalDateTime.now());
        if (discussService.addDiscuss(discuss) == 1) {
            return discuss;
        } else {
            return new Discuss();
        }
    }

    @RequestMapping(value = "/updateDiscuss", method = RequestMethod.POST)
    public Discuss updateDiscuss(@RequestBody Discuss discuss) {
        if (discussService.updateDiscuss(discuss) == 1) {
            return discuss;
        } else {
            return new Discuss();
        }
    }

    @RequestMapping(value = "/deleteDiscuss", method = RequestMethod.POST)
    public String deleteDiscussById(@RequestParam long id) {
        if (discussService.deleteDiscussById(id) == 1) {
            return "{\"status\":\"success\"}";
        }else {
            return "{\"status\":\"fail\"}";
        }
    }


    @RequestMapping(value = "/discuss/discussesbyhot", method = RequestMethod.POST)
    public List<Discuss> getHotDiscuss() {
        return discussService.getHotDiscuss();
    }

}
