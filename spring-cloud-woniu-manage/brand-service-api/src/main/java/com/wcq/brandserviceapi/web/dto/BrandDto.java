package com.wcq.brandserviceapi.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BrandDto
 * @Date 2022/8/15 9:08
 * @Author legend
 */

@Data
public class BrandDto implements Serializable {

    private Long Id;
    private String name;
    private String image;
    private String letter;
}
