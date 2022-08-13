package com.goodservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author 俞洋
 * @date 2022/8/13 16:13
 * @Description
 */
@Configuration
@EnableFeignClients(basePackages = {"com.wcq.category.api.http","com.wcq.brandserviceapi.http"})
public class FeginConfig {
}
