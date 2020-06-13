package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalanced;
import com.atguigu.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: wm
 * @Date: 2020-04-29  17:45
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalanced loadBalanced; //自定义的负载均衡
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Integer id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        //如果是200
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444, "查询失败");
        }
    }

    //测试自定义负载均衡
    @GetMapping("/consumer/payment/getLB")
    public String getPayment() {
        //获取CLOUD-PAYMENT-SERVICE下的所有服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null && instances.size() <= 0) {
            return null;
        }
        //获取可以用实例
        ServiceInstance serviceInstance = loadBalanced.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
