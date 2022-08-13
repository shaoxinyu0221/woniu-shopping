package com.orderservice.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orderservice.dao.mysql.PayLogMysqlDao;
import com.orderservice.web.fo.PayLogFo;
import com.orderservice.web.dto.PayLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 14:40
 */
@RestController
@RequiredArgsConstructor
public class PayLogController {

    private final PayLogMysqlDao payLogMysqlDao;

    @PostMapping("/payLog/list")
    public ResponseEntity<PageInfo<PayLogDto>> getPayLogList(
            @RequestBody PayLogFo payLogFo){
        System.out.println("方法执行了");
        if (StringUtils.isEmpty(payLogFo.getPageNum())){
            payLogFo.setPageNum(1);
        }
        if (StringUtils.isEmpty(payLogFo.getPageSize())){
            payLogFo.setPageSize(3);
        }
        PageHelper.startPage(payLogFo.getPageNum(), payLogFo.getPageSize());
        List<PayLogDto> payLogDtos = payLogMysqlDao.getPayLog(payLogFo);
        PageInfo<PayLogDto> pageInfo = new PageInfo<>(payLogDtos);
        System.out.println(pageInfo);
        return ResponseEntity.ok(pageInfo);
    }
}
