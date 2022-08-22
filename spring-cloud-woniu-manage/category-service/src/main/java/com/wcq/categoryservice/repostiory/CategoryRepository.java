package com.wcq.categoryservice.repostiory;

import com.wcq.brandserviceapi.web.dto.BrandDto;
import com.wcq.category.api.web.dto.CategoryDto;
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
    private BrandRepository brandRepository;

    @Resource
    private CategoryDtoConverter converter;
    public List<CategoryDto> getCategoryRoot(){
        //获取到根顶点
        List<CategoryPo> categoryPoList = categoryDao.getCategoryRoot();
        //转换
        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        return categoryDtoList;
    }

    public List<CategoryDto> getCategoryPraent(Long id) {

        List<CategoryPo> categoryPoList=categoryDao.getCategroyParent(id);

        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        return  categoryDtoList;
    }


    public List<CategoryDto> getCategoryBrand(Integer id) {
        List<CategoryPo> categoryPoList = categoryDao.getCategoryBrand(id);
        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        for(CategoryDto category:categoryDtoList){
           List<BrandDto>  brandDtoList = brandRepository.getBrandInfo(category.getBrandId());
        }
        return  categoryDtoList;
    }
}
