package com.wcq.categoryservice;

import com.wcq.brandserviceapi.http.fallback.BrandServiceClientFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CategoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }

    @Bean
    public BrandServiceClientFallback brandServiceClientFallback() {
        return new BrandServiceClientFallback();
    }
}
