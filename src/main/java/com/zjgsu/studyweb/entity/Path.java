package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("Path")
public class Path {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private int heat;
    private String introduce;
    private String learn_time;
    private String image_url;
    
    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }
}
