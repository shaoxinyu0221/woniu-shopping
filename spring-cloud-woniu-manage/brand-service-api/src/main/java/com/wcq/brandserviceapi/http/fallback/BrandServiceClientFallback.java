package com.wcq.brandserviceapi.http.fallback;

import com.commons.utils.ResponseResult;
import com.wcq.brandserviceapi.http.BrandServiceClient;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName BrandServiceClientFallback
 * @Date 2022/8/15 10:02
 * @Author legend
 */
@Component
public class BrandServiceClientFallback implements BrandServiceClient {

    public ResponseResult<List<BrandDto>> getBrandInfo(Long id) {
        System.out.println("getDepartment() 方法的备胎方法执行了，意味着 openfeign http 请求失败。");
        return new ResponseResult<List<BrandDto>>(10086, "fallback return", null);
    }
}
