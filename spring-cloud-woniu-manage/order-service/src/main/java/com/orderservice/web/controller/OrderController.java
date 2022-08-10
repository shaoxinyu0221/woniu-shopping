package com.orderservice.web.controller;

import com.commons.utils.ResponseResult;
import com.orderservice.dao.mysql.OrderMysqlDao;
import com.orderservice.web.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 17:58
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderMysqlDao orderMysqlDao;

    @GetMapping("/order/list")
    public ResponseResult<List<OrderDto>> getOrderList(){
        System.out.println("123132131312");
        List<OrderDto> orderDtoList = orderMysqlDao.getOrderList();
        return new ResponseResult<>(200,"ok",orderDtoList);
    }

}
