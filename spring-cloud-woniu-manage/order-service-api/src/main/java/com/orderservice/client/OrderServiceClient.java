package com.orderservice.client;

import com.orderservice.client.fallback.OrderServiceClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 17:56
 */
@FeignClient(value = "order-service",fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {

}
