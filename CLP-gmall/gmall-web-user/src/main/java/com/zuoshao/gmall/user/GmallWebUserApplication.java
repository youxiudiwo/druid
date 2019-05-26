package com.zuoshao.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//阻止springboot自动注入dataSource bean
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GmallWebUserApplication {


    public static void main(String[] args) {
        SpringApplication.run(GmallWebUserApplication.class, args);
    }

}
