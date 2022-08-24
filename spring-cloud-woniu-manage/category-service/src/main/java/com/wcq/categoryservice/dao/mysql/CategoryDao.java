package com.wcq.categoryservice.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcq.category.api.web.dto.CategoryDto;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDao extends BaseMapper<CategoryPo> {

    @Select("select * from tb_category where parent_id=0;")
    List<CategoryPo> getCategoryRoot();

    @Select("select * from tb_category where parent_id=#{id}")
    List<CategoryPo> getCategroyParent(Long id);

    List<CategoryDto> getCategoryBrand(Integer id);

    @Update("update tb_category set name=#{newName} where id=#{id}")
    Integer updateRootName(@Param("id") Long id,@Param("newName") String newName);

    @Insert("insert into tb_category(name,parent_id,is_parent,sort)" +
            " values(#{category.name},#{category.parentId},#{category.isParent},#{category.sort})")
    Integer addRootCategory(@Param("category") CategoryPo categoryPo);
}
