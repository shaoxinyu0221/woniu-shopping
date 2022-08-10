package com.orderservice.web.controller;

import com.commons.utils.ResponseResult;
import com.orderservice.dao.mysql.OrderDetailMysqlDao;
import com.orderservice.web.dto.OrderDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 20:04
 */
@RestController
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailMysqlDao orderDetailMysqlDao;

    @GetMapping("/order/item/list")
    public ResponseResult<List<OrderDetailDto>> getOrderDetailByOrderId(String orderId){
        List<OrderDetailDto> orderDetailList = orderDetailMysqlDao.getListByOrderId(orderId);
        return new ResponseResult<>(200,"ok",orderDetailList);
    }

}
