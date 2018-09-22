package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("User")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer gender;
}
