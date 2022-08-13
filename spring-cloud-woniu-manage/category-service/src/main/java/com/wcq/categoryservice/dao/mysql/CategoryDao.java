package com.wcq.categoryservice.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryDao extends BaseMapper<CategoryPo> {

    @Select("select * from tb_category where parent_id=0;")
    List<CategoryPo> getCategoryRoot();
}
