package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("User")
public class User {

    @TableId(type = IdType.AUTO)
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
    private String image_url;
    private String signature;
    private String speciality;
}
