package com.myproject.admin.controller;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseCart;
import com.myproject.admin.service.CmsCourseCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CmsCourseCartController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 19:37
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsCourseCartController", description = "购物车管理")
@RequestMapping("/courseCart")
public class CmsCourseCartController {

    @Autowired
    private CmsCourseCartService courseCartService;

    @ApiOperation(value = "课程加入购物车")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization") String myHeader,
                            @RequestBody CmsCourseCart cart){
        return courseCartService.add(cart);
    }

    @ApiOperation(value = "查看购物车列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization") String myHeader){
        List<CmsCourseCart> list = courseCartService.list();
        return CommonResult.success(list);
    }

}
