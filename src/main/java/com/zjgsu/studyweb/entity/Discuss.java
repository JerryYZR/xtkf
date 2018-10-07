package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Discuss")
public class Discuss {
    private Long id;
    private String name;
    private LocalDateTime create_time;
    private Integer heat;
}
