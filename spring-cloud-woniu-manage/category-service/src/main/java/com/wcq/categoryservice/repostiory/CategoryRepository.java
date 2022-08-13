package com.wcq.categoryservice.repostiory;

import com.wcq.categoryservice.web.controller.dto.CategoryDto;
import com.wcq.categoryservice.dao.mysql.CategoryDao;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import com.wcq.categoryservice.web.controller.dto.converter.CategoryDtoConverter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CategoryRepository
 * @Date 2022/8/13 10:21
 * @Author legend
 */

@Repository
public class CategoryRepository {

    @Resource
    private CategoryDao categoryDao;

    @Resource
    private CategoryDtoConverter converter;
    public List<CategoryDto> getCategoryRoot(){
        //获取到根顶点
        List<CategoryPo> categoryPoList = categoryDao.getCategoryRoot();
        //转换
        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        return categoryDtoList;
    }

}
