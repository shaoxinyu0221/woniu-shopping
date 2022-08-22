package com.wcq.brandservice.repository;

import com.wcq.brandservice.dao.mysql.BrandDao;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.stereotype.Repository;

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

    public List<BrandDto> getBrandInfoByid(Integer id) {

        List<BrandDto> brandDtoList = brandDao.getBrandInfoByid(id);

        return  brandDtoList;
    }
}
