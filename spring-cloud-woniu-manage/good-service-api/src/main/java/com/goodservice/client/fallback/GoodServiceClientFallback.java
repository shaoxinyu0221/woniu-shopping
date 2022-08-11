package com.goodservice.client.fallback;

import com.goodservice.client.GoodServiceClient;
import com.goodservice.web.dto.SkuDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 23:11
 */
public class GoodServiceClientFallback implements GoodServiceClient {

    @Override
    public ResponseEntity<SkuDto> getSkuById(String skuId) {
        return ResponseEntity.notFound().build();
    }
}
