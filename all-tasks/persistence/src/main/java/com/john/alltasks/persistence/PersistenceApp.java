package com.john.alltasks.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description:
 */
@SpringBootApplication
@EnableEurekaClient
public class PersistenceApp {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApp.class, args);
    }
}
