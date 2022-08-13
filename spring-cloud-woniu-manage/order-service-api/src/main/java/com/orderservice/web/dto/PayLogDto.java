package com.orderservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 14:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PayLogDto {

    @JsonProperty("orderId")
    private String orderId;
    //支付金额,单位:分
    @JsonProperty("totalFee")
    private BigDecimal totalFee;
    @JsonProperty("userId")
    private Integer userId;
    //微信交易号
    @JsonProperty("transactionId")
    private String transactionId;
    private Integer status;
    //支付方式,1微信支付,2货到付款
    @JsonProperty("payType")
    private Integer payType;
    //银行类型
    @JsonProperty("bankType")
    private String bankType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Date payTime;
    //关闭时间
    private Date closeTime;
    //退款时间
    private Date refundTime;
}
