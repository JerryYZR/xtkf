package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("DiscussTutor")
public class DiscussTutor {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long discuss_id;
    private Long tutor_id;
}
