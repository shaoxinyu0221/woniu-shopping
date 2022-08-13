package com.goodservice.web.controller;

import com.commons.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.goodservice.repository.SpuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 俞洋
 * @date 2022/8/13 14:35
 * @Description
 */
@RestController
@RequiredArgsConstructor
public class SpuController {
    private final SpuRepository spuRepository;

    @GetMapping("/spu/list")
    public ResponseResult<PageInfo> getSpuList(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                               @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo spuDtoList = spuRepository.getSpuList(pageNum,pageSize);
        return new ResponseResult<>(200, "ok", spuDtoList);
    }
}
