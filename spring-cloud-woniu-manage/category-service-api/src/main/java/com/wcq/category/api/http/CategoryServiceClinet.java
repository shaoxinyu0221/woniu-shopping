package com.wcq.category.api.http;

import com.commons.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName CategoryServiceClinet
 * @Date 2022/8/13 14:23
 * @Author legend
 */

@FeignClient(name = "category-service")
public interface CategoryServiceClinet {
    @GetMapping("/category/root")
    ResponseResult getCategoryRoot();
}
