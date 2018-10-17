package com.zjgsu.studyweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjgsu.studyweb.entity.Question;
import com.zjgsu.studyweb.entity.QuestionUser;
import com.zjgsu.studyweb.entity.Reply;
import com.zjgsu.studyweb.mapper.QuestionMapper;
import com.zjgsu.studyweb.mapper.QuestionUserMapper;
import com.zjgsu.studyweb.mapper.ReplyMapper;
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
        queryWrapper.eq("create_userId", create_userId);
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
}
