package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("Course")
public class Course {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer heat;
    private String introduce;
    private Integer learn_time;
    private String url;
    private Integer degree;
    private Long path_id;
}
