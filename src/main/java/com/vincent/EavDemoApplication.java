package com.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vincent.util.mapper")
public class EavDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EavDemoApplication.class, args);
    }

}
