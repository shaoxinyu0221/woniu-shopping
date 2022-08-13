package com.wcq.categoryservice.web.controller;

import com.commons.utils.ResponseResult;
import com.wcq.categoryservice.web.controller.dto.CategoryDto;
import com.wcq.categoryservice.repostiory.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CategoryController
 * @Date 2022/8/13 10:00
 * @Author legend
 */
@RestController
public class CategoryController {

    @Resource
    private CategoryRepository categoryRepository;
    @GetMapping("/category/root")
    public ResponseResult getCategoryRoot(){

        List<CategoryDto> categoryRoot = categoryRepository.getCategoryRoot();
        return new ResponseResult<>(200,"ok",categoryRoot);
    }
}
