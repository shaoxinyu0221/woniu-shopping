package com.wcq.category.api.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @ClassName CategoryDto
 * @Date 2022/8/13 10:23
 * @Author legend
 */

@Data
public class CategoryDto implements Serializable {
    private Long id;

    private String name;
    private Long parentId;
    private Integer isParent;
    private Integer sort;

    private String brandName;
    private Long brandId;
}
