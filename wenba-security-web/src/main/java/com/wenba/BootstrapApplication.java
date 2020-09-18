package com.wenba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 启动类
 * @author: tongrongbing
 * @date: 2020-07-23 10:37
 **/
@SpringBootApplication
@RestController
public class BootstrapApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class,args);
    }



}
