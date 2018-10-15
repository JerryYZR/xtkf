package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("Path")
public class Path {


    private Integer id;

    private String name;

    private int heat;

    private String introduce;

    private String learn_time;

}
