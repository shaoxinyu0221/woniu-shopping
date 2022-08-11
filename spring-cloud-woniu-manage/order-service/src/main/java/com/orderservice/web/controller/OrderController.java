package com.orderservice.web.controller;

import com.commons.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orderservice.dao.mysql.OrderMysqlDao;
import com.orderservice.web.dto.OrderDto;
import com.orderservice.web.fo.OrderPageFo;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
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
    public ResponseResult<PageInfo<OrderDto>> getOrderList(OrderPageFo fo){
        if (StringUtils.isEmpty(fo.getPageNum())){
            fo.setPageNum(1);
        }
        if (StringUtils.isEmpty(fo.getPageSize())){
            fo.setPageSize(3);
        }
        PageHelper.startPage(fo.getPageNum(), fo.getPageSize());
        List<OrderDto> orderDtoList = orderMysqlDao.getOrderList();
        PageInfo<OrderDto> pageInfo = new PageInfo<>(orderDtoList);
        return new ResponseResult<>(200,"ok",pageInfo);
    }

}
