package com.orderservice.web.controller;

import com.commons.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodservice.client.GoodServiceClient;
import com.goodservice.web.dto.SkuDto;
import com.orderservice.dao.mysql.OrderMysqlDao;
import com.orderservice.service.OrderService;
import com.orderservice.web.dto.OrderDto;
import com.orderservice.web.fo.OrderPageFo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private GoodServiceClient goodServiceClient;
    @Resource
    private OrderService orderService;

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

    @GetMapping("/order/test")
    public void testClient(){
        ResponseEntity<SkuDto> sku = goodServiceClient.getSkuById("10493538594");
        System.out.println(sku);
    }

    @PostMapping("/order/delete/{orderId}")
    public ResponseResult<Void> deleteOrder(@PathVariable("orderId") String orderId){
        orderService.deleteOrder(orderId);
        return new ResponseResult<>(200,"success",null);
    }

}
