package com.myproject.admin.controller;

import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.MasAdminParam;
import com.myproject.admin.dto.MasPermissionNode;
import com.myproject.admin.model.MasPermission;
import com.myproject.admin.service.MasPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "MasPermissionController", description = "后台权限管理")
@RequestMapping("/permission")
public class MasPermissionController {

    @Autowired
    private MasPermissionService permissionService;

    @ApiOperation(value = "返回所有权限(无树级)")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll () {
        List<MasPermission> permissions = permissionService.listAll();
        return CommonResult.success(CommonPage.restPage(permissions));
    }

    @ApiOperation(value = "返回所有权限(树级)")
    @RequestMapping(value = "/lisTree", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listTree () {
        return CommonResult.success(permissionService.listTree());
    }


    @ApiOperation(value = "添加权限")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add (@RequestHeader(name = "Authorization")String myHeader,
                             @RequestBody MasPermission permission) {
        int count = permissionService.add(permission);
        if (count > 0) {
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "根据ids删除权限")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestHeader(name = "Authorization")String myHeader,@RequestParam("ids") List<Long> ids){
        int count = permissionService.delete(ids);
        if (count > 0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "根据id修改权限")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody MasPermission permission) {
        int count = permissionService.update(id,permission);
        if (count > 0) {
            return CommonResult.success("更新成功");
        }
        return CommonResult.failed();
    }


}
