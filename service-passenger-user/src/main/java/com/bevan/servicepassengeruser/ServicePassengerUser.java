package com.bevan.servicepassengeruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbf
 * 2023/7/3 23:51
 */
@SpringBootApplication
@MapperScan("com.bevan.servicepassengeruser.mapper")
@EnableDiscoveryClient
public class ServicePassengerUser {
    public static void main(String[] args) {
        SpringApplication.run(ServicePassengerUser.class);
    }
}
