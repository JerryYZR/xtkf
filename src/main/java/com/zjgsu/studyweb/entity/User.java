package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("User")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer gender;
    private String major;
    private String introduce;
    private LocalDateTime birthday;
    private String school;
    private String academy;
    private String honor;
}
