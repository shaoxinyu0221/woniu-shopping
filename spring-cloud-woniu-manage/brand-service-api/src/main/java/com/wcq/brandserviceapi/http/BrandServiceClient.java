package com.wcq.brandserviceapi.http;

import com.commons.utils.ResponseResult;
import com.wcq.brandserviceapi.http.fallback.BrandServiceClientFallback;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name = "brand-service",fallback = BrandServiceClientFallback.class )
public interface BrandServiceClient {

    @GetMapping("/brand/getInfo/{id}")
    ResponseResult<List<BrandDto>> getBrandInfo(@PathVariable("id") Long id);

}
