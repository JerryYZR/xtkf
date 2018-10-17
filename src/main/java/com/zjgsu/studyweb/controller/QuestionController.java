package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Question;
import com.zjgsu.studyweb.entity.Reply;
import com.zjgsu.studyweb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/replys", method = RequestMethod.GET)
    public List<Reply> getAllReplys() {
        return questionService.getAllReplys();
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public Question getQuestion(@RequestParam long id) {
        return questionService.getQuestionById(id);
    }

    @RequestMapping(value = "/user/questions/userId", method = RequestMethod.POST)
    public List<Question> getQuestionsByUserId(@RequestParam long id) {
        return questionService.getQuestionsByUserId(id);
    }

    @RequestMapping(value = "/user/questions/createUserId", method = RequestMethod.POST)
    public List<Question> getQuestionsByCreateUserId(@RequestParam long id) {
        return questionService.getQuestionsByCreateUserId(id);
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

    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    public Reply addReply(@RequestParam String context) {
//        final String context = requestMap.get("context");
//        final String userId = requestMap.get("userId");
//        final String questionId = requestMap.get("questionId");
        Reply reply = new Reply();
        reply.setContext(context);
        reply.setQuestionId(Long.parseLong("1"));
        reply.setUserId(Long.parseLong("1"));
        questionService.addReply(reply);
        return reply;
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
