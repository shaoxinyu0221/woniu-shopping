package com.goodservice.dao.mysql;

import com.goodservice.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 10:27
 */
@Mapper
public interface CategoryMysqlDao {

    @Select("select * from tb_category where parent_id = 0")
    List<CategoryDto> getParentNode();

    @Select("select * from tb_category where parent_id = #{parentId}")
    List<CategoryDto> getListByParentId(Integer parentId);
}
