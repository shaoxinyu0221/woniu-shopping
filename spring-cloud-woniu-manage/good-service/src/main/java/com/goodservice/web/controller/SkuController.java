package com.goodservice.web.controller;

import com.goodservice.dao.mysql.SkuMysqlDao;
import com.goodservice.web.dto.SkuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 22:24
 */
@RestController
@RequiredArgsConstructor
public class SkuController {

    private final SkuMysqlDao skuMysqlDao;

    @GetMapping("/good/sku/{skuId}")
    public ResponseEntity<SkuDto> getSkuById(@PathVariable("skuId") String skuId){
        SkuDto skuDto = skuMysqlDao.getSkuById(skuId);
        return ResponseEntity.ok(skuDto);
    }

}
