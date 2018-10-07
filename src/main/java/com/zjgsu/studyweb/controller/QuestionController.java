package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Question;
import com.zjgsu.studyweb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public Question addQuestion(@RequestBody Question question) {
        question.setCreate_time(LocalDateTime.now());
        if (questionService.addQuestion(question) == 1) {
            return question;
        } else {
            return new Question();
        }
    }

    @RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
    public Question updateQuestion(@RequestBody Question question) {
        if (questionService.updateQuestion(question) == 1) {
            return question;
        } else {
            return new Question();
        }
    }

    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public String deleteQuestionById(@RequestParam long id) {
        if (questionService.deleteQuestionById(id) == 1) {
            return "{\"status\":\"success\"}";
        }else {
            return "{\"status\":\"fail\"}";
        }
    }
}
