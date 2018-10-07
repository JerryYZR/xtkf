package com.zjgsu.studyweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.zjgsu.studyweb.mapper","com.zjgsu.studyweb.repository"})
public class StudyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyWebApplication.class, args);
    }
}
