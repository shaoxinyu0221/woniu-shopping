package com.wcq.categoryservice.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcq.categoryservice.dao.mysql.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<CategoryPo> {

}
