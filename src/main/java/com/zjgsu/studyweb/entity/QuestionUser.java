package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("QuestionUser")
public class QuestionUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer questionId;
    private Integer userId;
}
