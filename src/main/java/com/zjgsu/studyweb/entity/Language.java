package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Language")
public class Language {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer heat;
}
