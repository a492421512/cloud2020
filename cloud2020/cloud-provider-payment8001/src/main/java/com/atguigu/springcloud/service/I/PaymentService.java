package com.atguigu.springcloud.service.I;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Author: wm
 * @Date: 2020-04-12  16:30
 * @Version 1.0
 */
public interface PaymentService {

    public abstract int create(Payment payment);

    public abstract Payment getPaymentById(Long id);
}
