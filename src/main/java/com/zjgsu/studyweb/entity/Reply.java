package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Reply")
public class Reply {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String context;
    private Long user_id;
    private Long question_id;
    private Long reply_to_user_id;
    private LocalDateTime create_time;
}
