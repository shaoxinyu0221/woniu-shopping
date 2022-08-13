package com.goodservice.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.goodservice.dao.mysql.po.SpuPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 俞洋
 * @date 2022/8/12 11:45
 * @Description
 */
@Mapper
public interface SpuMysqlDao extends BaseMapper<SpuPo> {


}
