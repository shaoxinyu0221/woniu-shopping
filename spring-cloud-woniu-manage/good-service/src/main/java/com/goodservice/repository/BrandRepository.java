package com.goodservice.repository;

import com.wcq.brandserviceapi.http.BrandServiceClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author 俞洋
 * @date 2022/8/13 15:44
 * @Description
 */
@Repository
public class BrandRepository {
    @Resource
    private BrandServiceClient brandServiceClient;

}
