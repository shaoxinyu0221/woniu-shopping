package com.orderservice.web.controller;

import com.orderservice.dao.mysql.ShippingMysqlDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 14:23
 */
@RestController
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingMysqlDao shippingMysqlDao;




}
