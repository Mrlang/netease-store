package com.netease.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//注册到eureka server
@EnableDiscoveryClient
public class StoreApplication {

    @Bean
//    添加@LoadBalanced注解，可为RestTemplate整合ribbon，使其具备负载均衡能力
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
}
