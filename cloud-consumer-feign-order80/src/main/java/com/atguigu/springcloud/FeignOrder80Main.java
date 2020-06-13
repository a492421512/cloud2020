package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wm
 * @Date: 2020-06-09  16:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
public class FeignOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80Main.class,args);
    }
}
