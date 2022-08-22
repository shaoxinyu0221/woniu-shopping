package com.goodservice.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodservice.dao.mysql.SpuMysqlDao;
import com.goodservice.dao.mysql.po.SpuPo;
import com.goodservice.web.controller.dto.convert.SpuDtoConvert;
import com.goodservice.web.dto.SpuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 俞洋
 * @date 2022/8/13 14:35
 * @Description
 */
@Repository
@RequiredArgsConstructor
public class SpuRepository {

    private final SpuMysqlDao spuMysqlDao;
    private final SpuDtoConvert spuDtoConvert;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public PageInfo getSpuList(Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //查询转dto
        List<SpuPo> spuPoList = spuMysqlDao.selectList(null);
        List<SpuDto> spuDtoList = spuDtoConvert.from(spuPoList);
        //查类别
        List<SpuDto> spuDtos = categoryRepository.queryCategory(spuDtoList,spuPoList);

        System.out.println(spuDtos);
        return null;
    }
}
