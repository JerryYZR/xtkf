package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.*;
import com.zjgsu.studyweb.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionUserMapper questionUserMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    QuestionTutorMapper questionTutorMapper;

    @Autowired
    UserMapper userMapper;

    public List<Question> getAllQuestions() {
        return questionMapper.selectList(null);
    }

    public Question getQuestionById(long id) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return questionMapper.selectOne(queryWrapper);
    }

    public List<Question> getQuestionsByUserId(Long userId) {
        List<QuestionUser> questionsIdList = new ArrayList<>();
        QueryWrapper<QuestionUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        questionsIdList = questionUserMapper.selectList(queryWrapper);

        List<Question> discussesList = new ArrayList<>();
        for (QuestionUser questionUser : questionsIdList) {
            QueryWrapper<Question> queryWrapper_question = new QueryWrapper<>();
            queryWrapper_question.eq("id", questionUser.getQuestionId());
            discussesList.add(questionMapper.selectOne(queryWrapper_question));
        }

        return discussesList;
    }

    public List<Question> getQuestionsByCreateUserId(Long create_userId) {
        List<Question> questionList = new ArrayList<>();
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user_id", create_userId);
        questionList = questionMapper.selectList(queryWrapper);

        return questionList;
    }

    public List<Question> getQuestionsByDiscussId(Long discussId) {
        List<Question> questionList = new ArrayList<>();
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("discuss_id", discussId);
        questionList = questionMapper.selectList(queryWrapper);

        return questionList;
    }

    public Integer addQuestion(Question question) {
        return questionMapper.insert(question);
    }

    public Integer updateQuestion(Question question) {
        return questionMapper.updateById(question);
    }

    public Integer deleteQuestionById(long id) {
        return questionMapper.deleteById(id);
    }


    public void addReply(Reply reply) {
        replyMapper.insert(reply);
    }

    public List<Reply> getAllReplys() {
        return replyMapper.selectList(null);
    }

    public List<Reply> getReplysByQuestionId(Long questionId) {
        List<Reply> replyList = new ArrayList<>();
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("question_id", questionId);
        replyList = replyMapper.selectList(queryWrapper);

        return replyList;
    }

    public List<Question> getQuestionsByTutorId(Long tutorId) {
        List<QuestionTutor> questionsIdList = new ArrayList<>();
        QueryWrapper<QuestionTutor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tutor_id", tutorId);
        questionsIdList = questionTutorMapper.selectList(queryWrapper);

        List<Question> discussesList = new ArrayList<>();
        for (QuestionTutor questionTutor : questionsIdList) {
            QueryWrapper<Question> queryWrapper_question = new QueryWrapper<>();
            queryWrapper_question.eq("id", questionTutor.getQuestion_id());
            discussesList.add(questionMapper.selectOne(queryWrapper_question));
        }

        return discussesList;
    }

    public List<User> getTutorsByQuestionId(Long questionId) {
        List<QuestionTutor> questionsIdList = new ArrayList<>();
        QueryWrapper<QuestionTutor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("question_id", questionId);
        questionsIdList = questionTutorMapper.selectList(queryWrapper);

        List<User> usersList = new ArrayList<>();
        for (QuestionTutor questionTutor : questionsIdList) {
            QueryWrapper<User> queryWrapper_user = new QueryWrapper<>();
            queryWrapper_user.eq("id", questionTutor.getTutor_id());
            usersList.add(userMapper.selectOne(queryWrapper_user));
        }

        return usersList;
    }
}
