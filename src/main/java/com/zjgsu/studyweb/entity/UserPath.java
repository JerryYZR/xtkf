package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("UserPath")
public class UserPath {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userid;
    private Long pathid;
}
