package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("UserTutor")
public class UserTutor {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long user_id;
    private Long tutor_id;
}
