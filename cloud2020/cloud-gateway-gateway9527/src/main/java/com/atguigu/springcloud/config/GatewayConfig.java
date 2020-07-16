package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wm
 * @Date: 2020-07-13  15:06
 * @Version 1.0
 */
//硬编码模式配置网关
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        //创建认真中心
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu",r ->
                r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
