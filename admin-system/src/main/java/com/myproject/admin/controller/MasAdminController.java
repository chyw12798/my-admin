package com.myproject.admin.controller;

import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.*;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.model.MasPermission;
import com.myproject.admin.service.MasAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller类的编写:
 *      1、在类上添加controller、api、requestsMapping注解
 *      2、在每个方法上添加apiOperation、requestMapping、responseBody注解
 */
@Controller
@Api(tags = "MasAdminController", description = "后台用户(管理员)管理")
@RequestMapping("/admin")
public class MasAdminController {

    @Autowired
    private MasAdminService adminService;


    // 写到这里就要在admin-system里添加comm、mbg包了
    @ApiOperation(value = "管理用户登录返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login (@RequestBody MasAdminParam adminParam) {
        String token = adminService.login(adminParam);
        Map<String ,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("header", "hearder");
        return CommonResult.success(token);
    }

    @ApiOperation(value = "获取验证码")
    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getVerificationCode (@RequestParam(value = "phone",required = false) String phone) {
        return adminService.getVerificationCode(phone);

    }

    @ApiOperation(value = "验证码登录")
    @RequestMapping(value = "/veificationCodelogin", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult veificationCodelogin (@RequestBody VerificationCodeLoginParam verificationCodeLoginParam) {
        return adminService.veificationCodelogin(verificationCodeLoginParam);

    }



    // 注册用户
    @ApiOperation(value = "后台用注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody MasAdminParam adminParam) {
        return adminService.register(adminParam.getUserName(),adminParam.getPassword());
    }


    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(@RequestHeader(name = "Authorization")String myHeader,
                             Principal principal) {
        // 登录的时候返回的用户信息
        return null;
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout(Principal principal) {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader,
                             @RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<MasAdmin> adminList = adminService.list(userName,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestHeader(name = "Authorization")String myHeader,
                                       @RequestBody UpdatePasswordParam updatePasswordParam){
        return adminService.updatePassword(updatePasswordParam);
    }

//    @ApiOperation("忘记密码")
//    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult forgetPassword(@RequestBody UpdatePasswordParam updatePasswordParam){
//        return adminService.updatePassword(updatePasswordParam);
//    }

    @ApiOperation("获取用户权限")
    @RequestMapping(value = "/permissionList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult permissionList(@RequestHeader(name = "Authorization")String myHeader,
                                       @RequestParam("id") Long id) {

        // 权限这一块，需求如此：
        // 权限管理展示所有树级权限
        // 角色管理展示所有树级权限，将角色对应权限映射到所有树级权限中
        // 用户管理展示角色的树级权限，将用户对应的权限映射到角色的树级权限中
        List<MasPermission> permissions = adminService.permissionList(id);
        return CommonResult.success(permissions);
    }

    @ApiOperation("修改用户权限")
    @RequestMapping(value = "/permissionUpdate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult permissionUpdate(@RequestHeader(name = "Authorization")String myHeader,
                                         @RequestBody UpdateAdminPermissionParam updateAdminPermissionParam) {
        return adminService.permissionUpdate(updateAdminPermissionParam);
    }

    @ApiOperation("给用户分配角色(+权限)")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult roleUpdate(@RequestHeader(name = "Authorization")String myHeader,
                                         @RequestBody UpdateAdminRoleParam updateAdminRoleParam) {
        return adminService.roleUpdate(updateAdminRoleParam);
    }
}
