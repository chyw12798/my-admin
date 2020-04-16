package com.myproject.admin.controller;

import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.UpdateRolePemissions;
import com.myproject.admin.model.MasRole;
import com.myproject.admin.service.MasRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "MasRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class MasRoleController {

    @Autowired
    private MasRoleService roleService;

    @ApiOperation(value = "后台角色列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader,
                             @RequestParam(value = "roleName", required = false) String roleName,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<MasRole> roleList = roleService.list(roleName, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation(value = "后台角色列表查询(不分页)")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader) {
        List<MasRole> roleList = roleService.listAll();
        return CommonResult.success(roleList);
    }

    @ApiOperation(value = "添加后台角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody MasRole masRole) {
        int count = roleService.add(masRole);
        if (count > 0) {
            return CommonResult.success("角色添加成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "修改后台角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestHeader(name = "Authorization")String myHeader,
                               @PathVariable Long id, @RequestBody MasRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success("角色修改成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "批量删除后台角色")
    @RequestMapping(value = "/deleteMany", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteMany(@RequestHeader(name = "Authorization")String myHeader,
                                   @RequestParam(value = "ids") List<Long> ids) {
        int count = roleService.deleteMany(ids);
        if (count > 0) {
            return CommonResult.success("角色删除成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "修改后台角色权限")
    @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestHeader(name = "Authorization")String myHeader,
                                         @RequestBody UpdateRolePemissions updateRolePemissions) {
        // 一个用户只能有一种角色，角色可以有很多用户
        // 修改角色权限会同样修改对应用户的权限
        int count = roleService.updatePermission(updateRolePemissions);
        if (count > 0) {
            return CommonResult.success("角色更新成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "后台角色树级权限")
    @RequestMapping(value = "/permissionTreeList/{roleId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult permissionTreeList(@RequestHeader(name = "Authorization")String myHeader,
                                           @PathVariable("roleId") Long roleId) {
        return CommonResult.success(roleService.permissionTreeList(roleId));
    }
}
