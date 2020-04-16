package com.myproject.admin.controller;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.service.CmsCourseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CmsCourseOrderController
 * @Description 与电商不同的是，电商一个订单会包含很多商品，课程下单就直接对应一个课程
 * @Author chyw1
 * @Date 2020/3/19 9:48
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsCourseOrderController", description = "订单管理")
@RequestMapping("/courseOrder")
public class CmsCourseOrderController {

    @Autowired
    private CmsCourseOrderService courseOrderService;

    @ApiOperation(value = "通过主页直接创建订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization") String myHeader,
                            @RequestBody Long cmsCourseId){
        int count = courseOrderService.add(cmsCourseId);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "创建订单,进入预览商品页面")
    @RequestMapping(value = "/showCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult showCourse(@RequestHeader(name = "Authorization") String myHeader,
                                   @RequestParam(value = "courseId",required = true) Long courseId){
        courseOrderService.showCourse(courseId);
        return null;
    }

}
