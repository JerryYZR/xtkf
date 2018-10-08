package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("QuestionUser")
public class QuestionUser {
    private Long id;
    private Integer questionId;
    private Integer userId;
}
