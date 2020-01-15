package com.john.alltasks.registercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterApp.class, args);
    }
}
