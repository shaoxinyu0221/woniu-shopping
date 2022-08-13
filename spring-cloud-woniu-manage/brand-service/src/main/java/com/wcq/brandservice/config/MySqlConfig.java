package com.wcq.brandservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.wcq.brandservice.dao.mysql")
public class MySqlConfig {
}
