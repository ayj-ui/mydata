package com.example.mydata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* */
@SpringBootApplication
@MapperScan(basePackages = "com.example.mydata.dao")
public class MydataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydataApplication.class, args);
    }

}
