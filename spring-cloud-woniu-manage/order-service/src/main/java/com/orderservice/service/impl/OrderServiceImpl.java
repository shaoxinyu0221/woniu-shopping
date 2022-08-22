package com.orderservice.service.impl;

import com.orderservice.dao.mysql.OrderMysqlDao;
import com.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 19:18
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMysqlDao orderMysqlDao;

    @Override
    public void deleteOrder(String orderId) {
        orderMysqlDao.updateViewStatus(orderId);
    }
}
