package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("QuestionTutor")
public class QuestionTutor {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long question_id;
    private Long questioner_id;
    private Long tutor_id;
}
