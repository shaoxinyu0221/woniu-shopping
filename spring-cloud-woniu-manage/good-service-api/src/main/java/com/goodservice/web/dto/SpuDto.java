package com.goodservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 俞洋
 * @date 2022/8/13 16:04
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuDto implements Serializable {
    private Integer id;
    private String title;
    //类别名
    private String categoryName;
    //品牌名
    private String brandName;
    //上下架
    private Integer saleable;
}