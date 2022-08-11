package com.goodservice.client;

import com.goodservice.client.fallback.GoodServiceClientFallback;
import com.goodservice.web.dto.SkuDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 23:07
 */
@FeignClient(value = "good-service",fallback = GoodServiceClientFallback.class)
public interface GoodServiceClient {

    @GetMapping("/good/sku/{skuId}")
    ResponseEntity<SkuDto> getSkuById(@PathVariable("skuId") String skuId);

}
