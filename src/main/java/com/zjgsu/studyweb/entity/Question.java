package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Question")
public class Question {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime create_time;
    private String author;
    private Integer reply;
    private Integer check_num;
    private Long create_userId;
    private Long discuss_id;
}
