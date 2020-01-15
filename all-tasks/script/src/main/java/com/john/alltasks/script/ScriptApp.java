package com.john.alltasks.script;

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
public class ScriptApp {

    public static void main(String[] args) {
        SpringApplication.run(ScriptApp.class, args);
    }
}
