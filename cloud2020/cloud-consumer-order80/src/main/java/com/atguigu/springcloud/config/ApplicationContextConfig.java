package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wm
 * @Date: 2020-04-29  17:43
 * @Version 1.0
 */
@SpringBootConfiguration
public class ApplicationContextConfig {

    //把RestTemplate注入容器
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
