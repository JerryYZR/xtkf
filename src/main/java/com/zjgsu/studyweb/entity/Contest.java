package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Contest")
public class Contest {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String url;
    private String answer_url;
    private Integer degree;
    private Long path_id;
}