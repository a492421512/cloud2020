package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wm
 * @Date: 2020-06-19  18:04
 * @Version 1.0
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT8001")
public interface PaymentService {

    @GetMapping("/payment/hystrix/getOk/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/getTimeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
