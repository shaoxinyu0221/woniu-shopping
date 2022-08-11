package com.orderservice;

import com.goodservice.client.fallback.GoodServiceClientFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.goodservice.client")
public class OrderServiceApplication {

    @Bean
    public GoodServiceClientFallback goodServiceClientFallback(){
        return new GoodServiceClientFallback();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
