package com.wcq.categoryservice.repostiory;

import com.commons.utils.ResponseResult;
import com.wcq.brandserviceapi.http.BrandServiceClient;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandRepository
 * @Date 2022/8/14 18:27
 * @Author legend
 */
@Repository
public class BrandRepository {

    @Resource
    private  BrandServiceClient brandServiceClient;

    public List<BrandDto> getBrandInfo(Long brandId) {

        ResponseResult<List<BrandDto>> brandInfo = brandServiceClient.getBrandInfo(brandId);
        return  brandInfo.getData();
    }
}
