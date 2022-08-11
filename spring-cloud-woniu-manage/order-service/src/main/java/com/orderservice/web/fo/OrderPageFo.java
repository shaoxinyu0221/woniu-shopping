package com.orderservice.web.fo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/11 18:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPageFo {

    private Integer pageNum;
    private Integer pageSize;
    private String accept;
    private Date orderTime;

}
