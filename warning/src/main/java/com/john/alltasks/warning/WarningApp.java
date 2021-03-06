package com.john.alltasks.warning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:
 */
@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class WarningApp {
    public static void main(String[] args) {
        SpringApplication.run(WarningApp.class, args);
    }
}
