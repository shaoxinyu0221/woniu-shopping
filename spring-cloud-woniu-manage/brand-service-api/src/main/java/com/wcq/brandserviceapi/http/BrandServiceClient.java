package com.wcq.brandserviceapi.http;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 俞洋
 * @date 2022/8/13 15:39
 * @Description
 */
@FeignClient("brand-service")
public interface BrandServiceClient {

}
