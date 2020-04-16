package com.myproject.admin.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.config.AlipayConfig;
import com.myproject.admin.dto.AliPayParam;
import com.myproject.admin.mapper.CmsCourseOrderMapper;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseOrder;
import com.myproject.admin.service.AliPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AliPayController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 9:18
 * @Version 1.0
 */
@Controller
@Api(tags = "AliPayController", description = "课程支付管理")
@RequestMapping("/alipay")
public class AliPayController {

    @Autowired
    private AliPayService aliPayService;

    @Autowired
    private CmsCourseOrderMapper courseOrderMapper;

    @ApiOperation(value = "页面点击确认支付按钮,进来这里,调了alipay的接口,返回result页面")
    @RequestMapping(value = "/pay",method = RequestMethod.POST,produces = "text/html; charset=UTF-8")
    @ResponseBody
    public void pay(@RequestBody AliPayParam aliPayParam, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CmsCourseOrder cmsCourseOrder = courseOrderMapper.selectByPrimaryKey(Long.parseLong(aliPayParam.getOut_trade_no()));
        if (cmsCourseOrder == null ) {
//            return "pagePayFail";
        }
//        Product product = productService.getProductById(order.getProductId());

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = aliPayParam.getOut_trade_no();
        //付款金额，必填
        String total_amount = aliPayParam.getTotal_amount();
        //订单名称，必填
        String subject = aliPayParam.getSubject();
        //商品描述，可空
        String body = aliPayParam.getBody();

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
            String result = alipayClient.pageExecute(alipayRequest).getBody();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();
//        return result;
    }

    @ApiOperation(value = "支付宝同步通知页面")
    @RequestMapping(value = "/alipayReturnNotice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult alipayReturnNotice(HttpServletRequest request) throws Exception{
        return aliPayService.alipayReturnNotice(request);
    }

    @ApiOperation(value = "支付宝异步通知页面")
    @RequestMapping(value = "/alipayNotifyNotice", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult alipayNotifyNotice(HttpServletRequest request) throws Exception{
        return aliPayService.alipayNotifyNotice(request);
    }




}
