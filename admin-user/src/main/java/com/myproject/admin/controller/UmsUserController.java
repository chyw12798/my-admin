package com.myproject.admin.controller;

import com.myproject.admin.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UmsUserController
 * @Description 客户用户管理
 * @Author chyw1
 * @Date 2020/3/13 11:25
 * @Version 1.0
 */
@Controller
@Api(tags = "MasAdminController", description = "客户用户管理")
@RequestMapping("/admin")
public class UmsUserController {

//    // 写到这里就要在admin-system里添加comm、mbg包了
//    @ApiOperation(value = "用户登录返回token")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult login (@RequestBody MasAdminParam adminParam) {
//        String token = userService.login(adminParam);
//        Map<String ,String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
//        return CommonResult.success(tokenMap);
//    }

}
