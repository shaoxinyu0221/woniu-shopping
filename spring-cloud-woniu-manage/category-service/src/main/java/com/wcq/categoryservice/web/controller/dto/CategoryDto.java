package com.wcq.categoryservice.web.controller.dto;

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
    private BigInteger id;

    private String name;

    private BigInteger parentId;
    private Integer isParent;
    private Integer sort;

}
