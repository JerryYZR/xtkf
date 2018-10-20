package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("DiscussUser")
public class DiscussUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer discussId;
    private Integer userId;
}
