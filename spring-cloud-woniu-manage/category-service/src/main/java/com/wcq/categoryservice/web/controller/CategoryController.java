package com.wcq.categoryservice.web.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.commons.utils.ResponseResult;
import com.wcq.category.api.web.dto.CategoryDto;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import com.wcq.categoryservice.repostiory.CategoryRepository;
import com.wcq.categoryservice.service.CategoryService;
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

    @Resource
    private CategoryService categoryService;
    @GetMapping("/category/root")
    public ResponseResult<List<CategoryDto>> getCategoryRoot(){

        List<CategoryDto> categoryRoot = categoryRepository.getCategoryRoot();
        return new ResponseResult<List<CategoryDto>>(200,"ok",categoryRoot);
    }

    @GetMapping("/category/root/updateRootName")
    public ResponseResult<Integer> updateCategoryRootName(CategoryPo categoryPo){

        Integer updateCategoryRootName = categoryRepository.updateCategoryRootName(categoryPo);
        return new ResponseResult<>(200,"ok",updateCategoryRootName);
    }

    @GetMapping("/category/root/addroot")
    public ResponseResult addCategoryRoot(CategoryPo categoryPo){

        Integer addRootCategory = categoryService.addCategoryRoot(categoryPo);

        return new ResponseResult<>(200,"ok",addRootCategory);
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
