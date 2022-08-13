package com.orderservice.client.fallback;

import com.orderservice.client.OrderServiceClient;
import com.orderservice.web.fo.PayLogFo;
import com.orderservice.web.dto.PayLogDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 17:57
 */

public class OrderServiceClientFallback implements OrderServiceClient {
    @Override
    public ResponseEntity<List<PayLogDto>> getPayLogList(@RequestBody PayLogFo payLogFo) {
        return null;
    }
}
