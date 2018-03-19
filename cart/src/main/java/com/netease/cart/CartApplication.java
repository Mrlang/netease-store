package com.netease.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//声明这是一个eureka client
@EnableDiscoveryClient
@MapperScan("com.netease.cart")
public class CartApplication {
    @Bean
//    添加@LoadBalanced注解，可为RestTemplate整合ribbon，使其具备负载均衡能力
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}
}
