package com.wcq.categoryservice.service.imple;

import com.wcq.category.api.web.dto.CategoryDto;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import com.wcq.categoryservice.repostiory.CategoryRepository;
import com.wcq.categoryservice.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CategoryServiceImple
 * @Date 2022/8/23 14:30
 * @Author legend
 */
@Service
public class CategoryServiceImple implements CategoryService {
    @Resource
    private CategoryRepository categoryRepository;
    @Override
    public Integer addCategoryRoot(CategoryPo categoryPo) {
        //查询排序号码
        List<CategoryDto> categoryRoot = categoryRepository.getCategoryRoot();
        List<Integer> max = new ArrayList<>();
        //取出sort存入list
        categoryRoot.forEach(categoryDto -> max.add(categoryDto.getSort()));
        max.stream().max(Integer::compareTo).ifPresent(maxsort ->categoryPo.setSort(maxsort+1));
        categoryPo.setIsParent(1);
        categoryPo.setParentId(0L);
        Integer addCategoryRoot = categoryRepository.addCategoryRoot(categoryPo);
        return addCategoryRoot;
    }
}
