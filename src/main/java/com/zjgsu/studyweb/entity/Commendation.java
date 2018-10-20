package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data

@TableName("Commendation")
public class Commendation {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;//（评论用户）
    private String content;//评论内容
    private String type;//类型，路径或课程
    private LocalDateTime create_time;//评论时间
    private Long foreign_id;//路径或课程的id
}
