package com.orderservice.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @date 2022/8/10 17:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDto {

    private String orderId;
    //总金额, 单位为分
    private BigDecimal totalPay;
    //实付金额, 单位为分
    private BigDecimal actualPay;
    //支付类型 1:在线支付 2:货到付款
    private Integer paymentType;
    //邮费,单位为分
    private BigDecimal postFee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer userId;
    private String buyerNick;
    //是否已评价,0:未评价 1:已评价
    private Integer buyerRate;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverMobile;
    //收货人邮编
    private String receiverZip;
    private String receiver;
    //发票类型, 0:无发票 1:普通发票 2:电子发票 3:增值税发票
    private Integer invoiceType;
    //订单来源,1:app端 2:pc端 3:M端 4:微信端 5:手机qq端
    private Integer sourceType;

}
