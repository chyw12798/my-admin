package com.myproject.admin.controller;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.UmsUserLoginParam;
import com.myproject.admin.dto.UpdatePasswordParam;
import com.myproject.admin.model.UmsUser;
import com.myproject.admin.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Api(tags = "UmsUserController", description = "客户用户管理")
@RequestMapping("/user")
public class UmsUserController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsUserService userService;

    /**
     * 用户课推荐新用户注册，将会获得积分奖励，可在购物课程时获得优惠
     **/

    // 写到这里就要在admin-system里添加comm、mbg包了
    @ApiOperation(value = "用户登录返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login (@RequestBody UmsUserLoginParam userLoginParam) {
        String token = userService.login(userLoginParam);
        Map<String ,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register (@RequestBody UmsUser umsUser){
        return userService.register(umsUser);
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword (@RequestBody UpdatePasswordParam updatePasswordParam){
        return userService.updatePassword(updatePasswordParam);
    }
}
