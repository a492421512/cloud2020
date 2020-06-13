package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义的轮询负载均衡
 * @Author: wm
 * @Date: 2020-06-09  15:05
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalanced {

    //原子整数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取第几次访问
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            //当前的整数
            current = this.atomicInteger.get();
            //下一个整数,int 最大数2147483647 如果超出最大数重新开始,否则就是下一个
            next = current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问,next："+next);
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        // rest接口第几次请求 % 服务器集群的总数量= 实际调用服务器的下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
