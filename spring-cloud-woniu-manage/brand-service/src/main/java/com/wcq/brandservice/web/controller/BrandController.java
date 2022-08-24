package com.wcq.brandservice.web.controller;

import com.commons.utils.ResponseResult;
import com.wcq.brandservice.repository.BrandRepository;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandController
 * @Date 2022/8/13 9:41
 * @Author legend
 */

@RestController
public class BrandController {

    @Resource
    private BrandRepository brandRepository;

    @RequestMapping("/brand/{id}")
    public ResponseResult<List<BrandDto>> getBrandInfo(@PathVariable("id") Long id){
        System.out.println(id);
         List<BrandDto> brandDtoList =  brandRepository.getBrandInfoByid(id);
        System.out.println(brandDtoList+"*****");
         return new ResponseResult<>(200,"ok",brandDtoList);
    }

}
