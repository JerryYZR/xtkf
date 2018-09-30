package com.zjgsu.studyweb.service;

import com.zjgsu.studyweb.entity.Question;
import com.zjgsu.studyweb.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    public List<Question> getAllQuestions() {
        return questionMapper.selectList(null);
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
}
