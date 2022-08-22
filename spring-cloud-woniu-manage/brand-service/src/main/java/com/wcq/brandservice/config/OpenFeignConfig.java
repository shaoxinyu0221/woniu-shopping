package com.wcq.brandservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.wcq.category.api.http"})
public class OpenFeignConfig {
}
