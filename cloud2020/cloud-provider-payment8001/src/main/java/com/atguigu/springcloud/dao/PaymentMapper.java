package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wm
 * @Date: 2020-04-12  16:10
 * @Version 1.0
 */

@Mapper
public interface PaymentMapper {

    public abstract int create(Payment payment);

    public abstract Payment getPaymentById(Long id);
}
