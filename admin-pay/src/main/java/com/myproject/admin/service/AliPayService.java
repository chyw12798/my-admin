package com.myproject.admin.service;

import com.alipay.api.AlipayApiException;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.AliPayParam;
import com.myproject.admin.model.CmsCourseOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface AliPayService {
    String pay(AliPayParam aliPayParam) throws Exception;

    CommonResult alipayReturnNotice(HttpServletRequest request) throws Exception;

    CommonResult alipayNotifyNotice(HttpServletRequest request) throws Exception;
}
