package com.orderservice.web.fo;

import com.fasterxml.jackson.annotation.JsonFormat;
import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayLogFo {

    private Integer pageNum;
    private Integer pageSize;
    private String orderId;
    private String startPayTime;
    private String endPayTime;

}
