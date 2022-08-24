package com.wcq.brandservice.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcq.brandservice.dao.mysql.BrandDao;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandRepository
 * @Date 2022/8/15 9:18
 * @Author legend
 */
@Repository
public class BrandRepository {

    @Resource
    private BrandDao brandDao;

    public List<BrandDto> getBrandInfoByid(Long id) {

        List<BrandDto> brandDtoList = brandDao.getBrandInfoByid(id);

        return  brandDtoList;
    }

    public PageInfo<BrandDto> getBrandInfoAll(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);

        List<BrandDto> brandDtoList = brandDao.getBrandInfoAll(name);
        return new PageInfo<>(brandDtoList);
    }
}
