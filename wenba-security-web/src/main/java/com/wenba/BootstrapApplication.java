package com.wenba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: tongrongbing
 * @date: 2020-07-23 10:37
 **/
@SpringBootApplication
public class BootstrapApplication {
    public static void main(String[] args) {

        System.out.println("=====================");
        SpringApplication.run(BootstrapApplication.class,args);
    }


}
