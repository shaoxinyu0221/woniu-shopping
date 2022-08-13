package com.goodservice.repository;

import com.commons.utils.ResponseResult;
import com.goodservice.dao.mysql.po.SpuPo;
import com.goodservice.web.dto.SpuDto;
import com.wcq.category.api.dto.CategoryDto;
import com.wcq.category.api.http.CategoryServiceClinet;
import feign.FeignException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 俞洋
 * @date 2022/8/13 15:44
 * @Description
 */
@Repository
public class CategoryRepository {
    @Resource
    private CategoryServiceClinet categoryServiceClinet;


    public List<SpuDto> queryCategory(List<SpuDto> spuDtoList, List<SpuPo> spuPoList) {
        try {
            ResponseResult<List<CategoryDto>> responseResult = categoryServiceClinet.getCategoryRoot();
            List<CategoryDto> categoryRoot = responseResult.getData();
            for (int i = 0; i < spuPoList.size(); i++) {
                for (CategoryDto categoryDto : categoryRoot) {
                    if(categoryDto.getId()==spuPoList.get(i).getCid1()){
                        spuDtoList.get(i).setCategoryName(categoryDto.getName());
                    }
                }
            }
            return spuDtoList;
        } catch (Exception e) {
            for (SpuDto spuDto : spuDtoList) {
                spuDto.setCategoryName(null);
            }
            return spuDtoList;
        }
    }
}
