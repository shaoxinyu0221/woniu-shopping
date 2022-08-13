package com.orderservice.client;

import com.orderservice.client.fallback.OrderServiceClientFallback;
import com.orderservice.web.fo.PayLogFo;
import com.orderservice.web.dto.PayLogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 17:56
 */
@FeignClient(value = "order-service",fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {

    @PostMapping("/payLog/list")
    ResponseEntity<List<PayLogDto>> getPayLogList(@RequestBody PayLogFo payLogFo);

}
