package com.goodservice.web.controller.dto.convert;

import com.goodservice.dao.mysql.po.SpuPo;

import com.goodservice.web.dto.SpuDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 俞洋
 * @date 2022/8/13 15:19
 * @Description
 */
@Mapper(componentModel = "spring")
public interface SpuDtoConvert {
    SpuDto from(SpuPo spuPo);

    List<SpuDto> from(List<SpuPo> spuPoList);
}
