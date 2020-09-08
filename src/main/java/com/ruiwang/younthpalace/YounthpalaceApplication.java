package com.ruiwang.younthpalace;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.ruiwang.younthpalace.mapper")
public class YounthpalaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(YounthpalaceApplication.class, args);
    }

}
