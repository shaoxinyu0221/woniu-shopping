package com.orderservice.dao.mysql;

import com.orderservice.web.dto.OrderDto;
import com.orderservice.web.fo.OrderPageFo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 18:28
 */
@Mapper
public interface OrderMysqlDao {

    @Select("select * from tb_order where isView=0")
    List<OrderDto> getOrderList();

    @Update("update tb_order set isView=1 where order_id=#{orderId}")
    void updateViewStatus(String orderId);
}
