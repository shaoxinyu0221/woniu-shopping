package com.wcq.brandservice.dao.mysql.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @ClassName BrandPo
 * @Date 2022/8/13 9:34
 * @Author legend
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_brand")
public class BrandPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
        private BigInteger id;
        private String name;
        private String image;
        private String letter;


}
