package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Answer")
public class Answer {
    @TableId(type = IdType.AUTO)
    private Long id;
    private LocalDateTime create_time;
    private String content;
    private Integer support;
}
