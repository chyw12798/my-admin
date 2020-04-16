package com.myproject.admin.dto;

import lombok.Data;

/**
 * @ClassName AliPayParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/31 15:58
 * @Version 1.0
 */
@Data
public class AliPayParam {

    private String out_trade_no;
    //付款金额，必填
    private String total_amount;
    //订单名称，必填
    private String subject;
    //商品描述，可空
    private String body;
}
