package com.myproject.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CmsCustomerController
 * @Description 客服聊天接口(Netty)
 * @Author chyw1
 * @Date 2020/3/12 23:39
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsCustomerController", description = "客服接口")
@RequestMapping("/customer")
public class CmsCustomerController {
}
