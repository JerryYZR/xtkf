package com.zjgsu.studyweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjgsu.studyweb.mapper")
public class StudyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyWebApplication.class, args);
    }
}
