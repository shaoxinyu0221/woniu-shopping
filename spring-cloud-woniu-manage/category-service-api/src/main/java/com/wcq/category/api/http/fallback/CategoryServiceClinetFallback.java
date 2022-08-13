package com.wcq.category.api.http.fallback;

import com.commons.utils.ResponseResult;
import com.wcq.category.api.dto.CategoryDto;
import com.wcq.category.api.http.CategoryServiceClinet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 俞洋
 * @date 2022/8/13 17:08
 * @Description
 */
@Component
public class CategoryServiceClinetFallback implements CategoryServiceClinet {
    @Override
    public ResponseResult getCategoryRoot() {
        System.out.println("getCategoryRoot() 方法的备胎方法执行了，意味着 openfeign http 请求失败。");
        return new ResponseResult(10000, "category备胎方法启用", "N/A");
    }
}
