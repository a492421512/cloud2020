package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: wm
 * @Date: 2020-06-09  15:03
 * @Version 1.0
 */
public interface LoadBalanced {

    /**
     * 获取一个服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
