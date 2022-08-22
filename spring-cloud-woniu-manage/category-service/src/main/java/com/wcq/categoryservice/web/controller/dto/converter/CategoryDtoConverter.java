package com.wcq.categoryservice.web.controller.dto.converter;

import com.wcq.category.api.web.dto.CategoryDto;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses=CategoryDtoConverter.class)
public interface CategoryDtoConverter {

    CategoryDto from(CategoryPo categoryPo);

    List<CategoryDto> from(List<CategoryPo> categoryPoList);
}
