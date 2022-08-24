package com.wcq.brandservice.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcq.brandservice.dao.mysql.po.BrandPo;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

public interface BrandDao extends BaseMapper<BrandPo> {



    List<BrandDto> getBrandInfoByid(Long id);
}
