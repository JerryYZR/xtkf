<<<<<<< HEAD
package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data

@TableName("Commendation")
public class Commendation {
    private Long id;
    private String username;//（评论用户）
    private String content;//评论内容
    private String type;//类型，路径或课程
    private LocalDateTime create_time;//评论时间
    private Long foreign_id;//路径或课程的id
}
=======
package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data

@TableName("Commendation")
public class Commendation {
    private Long id;
    private String username;//（评论用户）
    private String content;//评论内容
    private String type;//类型，路径或课程
    private LocalDateTime create_time;//评论时间
    private Long foreign_id;//路径或课程的id
}
>>>>>>> 195e200b7c322f410b1a9b0cce9ef24057377cd2
