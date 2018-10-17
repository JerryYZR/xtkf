package com.zjgsu.studyweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Code")
public class Code {
    private Long id;
    private String name;
    private String url;
    private String introduce;
    private Long path_id;
}
