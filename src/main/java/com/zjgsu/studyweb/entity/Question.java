package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Question")
public class Question {
    private Long id;
    private String title;
    private Integer author;
    private LocalDateTime create_time;
    private String content;
    private Integer reply;
    private Integer check;
}
