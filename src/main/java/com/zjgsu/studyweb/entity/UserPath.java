package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("UserPath")
public class UserPath {
    private Long id;
    private Long userid;
    private Long pathid;
}
