package com.zjgsu.studyweb.controller;

import com.zjgsu.studyweb.entity.Question;
import com.zjgsu.studyweb.entity.Reply;
import com.zjgsu.studyweb.entity.User;
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

    @RequestMapping(value = "/user/questions/discussId", method = RequestMethod.POST)
    public List<Question> getQuestionsByDiscussId(@RequestParam long id) {
        return questionService.getQuestionsByDiscussId(id);
    }

    @RequestMapping(value = "/user/questions/tutorId", method = RequestMethod.POST)
    public List<User> getQuestionsByTutorId(@RequestParam long id) {
        return questionService.getTutorsByQuestionId(id);
    }

    @RequestMapping(value = "/user/tutors/questionId", method = RequestMethod.POST)
    public List<Question> getTutorsByQuestionId(@RequestParam long id) {
        return questionService.getQuestionsByTutorId(id);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public Question addQuestion(@RequestParam String title, @RequestParam String content,
                                @RequestParam Long create_user_id, @RequestParam Long discuss_id) {
        Question question = new Question();
        question.setDiscuss_id(discuss_id);
        question.setTitle(title);
        question.setContent(content);
        question.setCreate_user_id(create_user_id);
        question.setCheck_num(100);
        question.setCreate_time(LocalDateTime.now());
        System.out.println(question);
        if (questionService.addQuestion(question) == 1) {
            return question;
        } else {
            return new Question();
        }
    }

    @RequestMapping(value = "/reply/questionId", method = RequestMethod.POST)
    public List<Reply> getReplysByQuestionId(@RequestParam long id) {
        return questionService.getReplysByQuestionId(id);
    }

    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    public Reply addReply(@RequestParam String context, @RequestParam Long reply_to_user_id) {
//        final String context = requestMap.get("context");
//        final String userId = requestMap.get("userId");
//        final String questionId = requestMap.get("questionId");
        Reply reply = new Reply();
        reply.setContext(context);
        reply.setQuestion_id(Long.parseLong("1"));
        reply.setUser_id(Long.parseLong("1"));
        reply.setCreate_time(LocalDateTime.now());
        reply.setReply_to_user_id(reply_to_user_id);
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
