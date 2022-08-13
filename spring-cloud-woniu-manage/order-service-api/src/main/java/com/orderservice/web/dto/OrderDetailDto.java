package com.orderservice.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 20:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDetailDto {

    private Integer id;
    @JsonProperty("skuId")
    private String skuId;
    private Integer num;
    private String title;
    //商品属性键值对
    @JsonProperty("ownSpec")
    private String ownSpec;
    //商品价格,单位为分
    private Integer price;
    private String image;

}
