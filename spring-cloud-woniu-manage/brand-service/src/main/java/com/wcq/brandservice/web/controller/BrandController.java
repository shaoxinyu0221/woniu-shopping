package com.wcq.brandservice.web.controller;

import com.commons.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.wcq.brandservice.repository.BrandRepository;
import com.wcq.brandserviceapi.web.dto.BrandDto;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/brand/all")
    public ResponseResult<PageInfo<BrandDto>> getBrandInfoAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                              String name){

        PageInfo<BrandDto> brandDtoPageInfo= brandRepository.getBrandInfoAll(pageNum,pageSize,name);

        return new ResponseResult<>(200,"ok",brandDtoPageInfo);

    }
}
