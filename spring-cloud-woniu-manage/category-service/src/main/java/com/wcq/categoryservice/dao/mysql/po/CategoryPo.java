package com.wcq.categoryservice.dao.mysql.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @ClassName CategoryPO
 * @Date 2022/8/13 10:05
 * @Author legend
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_category")
public class CategoryPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Long parentId;
    private Integer isParent;
    private Integer sort;
    private Long brandId;
}
