package com.wcq.categoryservice.web.controller;

import com.commons.utils.ResponseResult;
import com.wcq.category.api.web.dto.CategoryDto;
import com.wcq.categoryservice.repostiory.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseResult<List<CategoryDto>> getCategoryRoot(){

        List<CategoryDto> categoryRoot = categoryRepository.getCategoryRoot();
        return new ResponseResult<List<CategoryDto>>(200,"ok",categoryRoot);
    }

    @GetMapping("/category/parent/{id}")
    public ResponseResult<List<CategoryDto>> getCategoryParent(@PathVariable("id") Long id){

        List<CategoryDto> categoryDtoList = categoryRepository.getCategoryPraent(id);

        return new ResponseResult<List<CategoryDto>>(200,"ok",categoryDtoList);
    }

    @GetMapping("/category/brand/{id}")
    public ResponseResult<List<CategoryDto>> getCategoryBrand(@PathVariable("id") Integer id){
        List<CategoryDto> categoryDtoList = categoryRepository.getCategoryBrand(id);
        return  new ResponseResult<>(200,"ok",categoryDtoList);
    }
}
