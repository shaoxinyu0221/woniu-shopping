package com.goodservice.dao.mysql;

import com.goodservice.web.dto.SkuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 22:25
 */
@Mapper
public interface SkuMysqlDao {

    @Select("select * from tb_sku where id=#{skuId}")
    SkuDto getSkuById(String skuId);
}
