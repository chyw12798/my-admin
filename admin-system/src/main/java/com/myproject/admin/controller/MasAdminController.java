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
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    // 写到这里就要在admin-system里添加comm、mbg包了
    @ApiOperation(value = "管理用户登录返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login (@RequestBody MasAdminParam adminParam) {
        String token = adminService.login(adminParam);
        if (token.equals("权限不足!")) {
            return CommonResult.failed("权限不足!");
        }
        Map<String ,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
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
    public CommonResult register(@RequestBody MasAdmin masAdmin) {
        return adminService.register(masAdmin);
    }


    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(@RequestHeader(name = "Authorization")String myHeader) {
        // 登录的时候返回的用户信息
        return CommonResult.success(adminService.info());
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout(Principal principal) {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader,
                             @RequestParam(value = "nickName", required = false) String nickName,
                             @RequestParam(value = "phone", required = false) String phone,
                             @RequestParam(value = "role", required = false) String role,
                             @RequestParam(value = "startTime", required = false) String startTime,
                             @RequestParam(value = "endTime", required = false) String endTime,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<MasAdminInfo> adminList = adminService.list(nickName,phone,role,startTime,endTime,pageNum,pageSize);
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
    @RequestMapping(value = "/roleUpdate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult roleUpdate(@RequestHeader(name = "Authorization")String myHeader,
                                         @RequestBody UpdateAdminRoleParam updateAdminRoleParam) {
        return adminService.roleUpdate(updateAdminRoleParam);
    }

    @ApiOperation("修改管理员状态")
    @RequestMapping(value = "/updateStatus/{adminId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@RequestHeader(name = "Authorization") String myHeader,
                                     @PathVariable Long adminId){

        int count = adminService.updateStatus(adminId);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("修改状态失败");
    }

    @ApiOperation("获取用户编辑信息")
    @RequestMapping(value = "/editInfo/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult editInfo(@RequestHeader(name = "Authorization")String myHeader,
                                     @PathVariable Long adminId){

        MasAdmin admin = adminService.editInfo(adminId);
        if (admin != null) {
            return CommonResult.success(admin);
        }
        return CommonResult.failed("获取数据失败");
    }

    @ApiOperation("更新用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestHeader(name = "Authorization") String myHeader,
                               @RequestBody MasAdminInfo adminInfo){
        int count = adminService.update(adminInfo);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("更新失败");
    }
}
