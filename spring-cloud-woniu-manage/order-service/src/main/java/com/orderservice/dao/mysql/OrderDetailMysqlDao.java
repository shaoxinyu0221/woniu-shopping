package com.orderservice.dao.mysql;

import com.orderservice.web.dto.OrderDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 20:05
 */
@Mapper
public interface OrderDetailMysqlDao {

    @Select("select * from tb_order_detail where order_id=#{orderId}")
    List<OrderDetailDto> getListByOrderId(String orderId);
}
