package com.goodservice.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/10 20:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SkuDto {

    private String id;
    private String title;
    private String images;
    private BigDecimal price;
    //特有规格属性在spu属性模板中的对应下标组合
    private String index;
    private String ownSpec;
    //是否有效，0无效，1有效
    private Integer enable;

}
