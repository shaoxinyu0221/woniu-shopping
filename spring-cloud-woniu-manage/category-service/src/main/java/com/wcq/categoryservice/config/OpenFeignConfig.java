package com.wcq.categoryservice.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.wcq.category.api.http")
public class OpenFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return  Logger.Level.BASIC;
    }

}
