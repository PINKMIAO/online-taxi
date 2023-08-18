package com.bevan.servicedriveruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zbf
 * 2023/8/11 11:06
 */
@SpringBootApplication
@MapperScan("com.bevan.servicedriveruser.mapper")
public class ServiceDriverUser {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUser.class);
    }
}
