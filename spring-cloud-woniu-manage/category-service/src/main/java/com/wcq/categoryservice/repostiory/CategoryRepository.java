package com.wcq.categoryservice.repostiory;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    /*
     * @description: TODO 查找根类别
     * @param:
 * @param null
     * @return:
     * @author 吴传棋
     * @date: 2022/8/23 13:07
     */

    public List<CategoryDto> getCategoryRoot(){
        //获取到根顶点
        List<CategoryPo> categoryPoList = categoryDao.getCategoryRoot();
        //转换
        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        return categoryDtoList;
    }
/*
 * @description: TODO 更改根类别名
 * @param:
 * @param null
 * @return:
 * @author 吴传棋
 * @date: 2022/8/23 13:43
 */

    public Integer updateCategoryRootName(CategoryPo categoryPo){
        Integer reultsUpdate= categoryDao.updateRootName(categoryPo.getId(),categoryPo.getName());
        return reultsUpdate;
    }

/*
 * @description: TODO 查找父类别
 * @param:
 * @param null
 * @return:
 * @author 吴传棋
 * @date: 2022/8/23 13:08
 */

    public List<CategoryDto> getCategoryPraent(Long id) {

        List<CategoryPo> categoryPoList=categoryDao.getCategroyParent(id);

        List<CategoryDto> categoryDtoList = converter.from(categoryPoList);
        return  categoryDtoList;
    }

/*
 * @description: TODO 查找父类别下的子类别以及的所有商品
 * @param:
 * @param null
 * @return:
 * @author 吴传棋
 * @date: 2022/8/23 13:08
 */

    public List<CategoryDto> getCategoryBrand(Integer id) {
        List<CategoryDto> categoryDtoList = categoryDao.getCategoryBrand(id);
        categoryDtoList.forEach(categoryDto -> System.out.println(categoryDto.getBrandId()+"**"));

        for(CategoryDto category:categoryDtoList){
            System.out.println(category.getBrandId());
           List<BrandDto>  brandDtoList = brandRepository.getBrandInfo(category.getBrandId());
          brandDtoList.forEach(BrandDto->category.setBrandName(BrandDto.getName()));
        }
        return  categoryDtoList;
    }

    public Integer addCategoryRoot(CategoryPo categoryPo) {
        Integer add  =categoryDao.addRootCategory(categoryPo);
        return  add;
    }

}
