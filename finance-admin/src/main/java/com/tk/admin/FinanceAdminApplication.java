package com.tk.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@SpringBootConfiguration
@MapperScan(value = "com.tk.admin.mapper")
@EnableCaching
public class FinanceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAdminApplication.class, args);
    }

}
