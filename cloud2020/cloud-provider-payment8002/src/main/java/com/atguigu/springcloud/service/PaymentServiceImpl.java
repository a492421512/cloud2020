package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.I.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.springcloud.mapper.PaymentMapper1;

/**
 * @Author: wm
 * @Date: 2020-04-12  16:31
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper1 paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
