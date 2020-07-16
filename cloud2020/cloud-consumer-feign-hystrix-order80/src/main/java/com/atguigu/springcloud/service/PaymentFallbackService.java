package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: wm
 * @Date: 2020-06-28  16:37
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "报错了500";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "报错了500";
    }
}
