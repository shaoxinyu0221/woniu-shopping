package com.wcq.category.api.http;

import com.commons.utils.ResponseResult;
import com.wcq.category.api.http.fallback.CategoryServiceClinetFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName CategoryServiceClinet
 * @Date 2022/8/13 14:23
 * @Author legend
 */

@FeignClient(name = "category-service",fallback = CategoryServiceClinetFallback.class)
public interface CategoryServiceClinet {
    @GetMapping("/category/root")
    ResponseResult getCategoryRoot();
}
