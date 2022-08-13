package com.goodservice;

import com.goodservice.client.fallback.GoodServiceClientFallback;
import com.wcq.category.api.http.CategoryServiceClinet;
import com.wcq.category.api.http.fallback.CategoryServiceClinetFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.goodservice.client")
public class GoodServiceApplication {

    @Bean
    public GoodServiceClientFallback goodServiceClientFallback(){
        return new GoodServiceClientFallback();
    }

    @Bean
    public CategoryServiceClinetFallback categoryServiceClinetFallback(){
        return new CategoryServiceClinetFallback();
    }

    public static void main(String[] args) {
        SpringApplication.run(GoodServiceApplication.class, args);
    }

}
