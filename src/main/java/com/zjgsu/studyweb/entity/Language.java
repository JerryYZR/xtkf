package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Language")
public class Language {
    private Long id;
    private String name;
    private Integer heat;
}
