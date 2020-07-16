package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wm
 * @Date: 2020-06-19  18:07
 * @Version 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "defaultHystrixMethod") //全局降级方法
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/getOk/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        //int a = 10/0;
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/getTimeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Timeout(id);
    }
    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "系统超时或代码错误，500";
    }

    public String defaultHystrixMethod(){
        return "系统超时，这是公共的方法";
    }
}
