package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Job")
public class Job {
    private Long id;
    private String name;
    private Integer heat;
}
