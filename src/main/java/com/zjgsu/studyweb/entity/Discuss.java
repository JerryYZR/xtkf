package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Discuss")
public class Discuss {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime create_time;
    private Integer heat;
    private Long create_userId;
}
