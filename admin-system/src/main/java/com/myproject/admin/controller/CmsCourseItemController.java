package com.myproject.admin.controller;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.CmsCourseCategoryNode;
import com.myproject.admin.model.CmsCourseItem;
import com.myproject.admin.service.CmsCourseItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CmsCourseItemController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/18 10:42
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsCourseItemController", description = "后台课程条目管理")
@RequestMapping("/courseItem")
public class CmsCourseItemController {

    @Autowired
    private CmsCourseItemService courseItemService;

    @ApiOperation(value = "查看某个课程所有条目")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll(@RequestHeader(name = "Authorization")String myHeader,
                                 @RequestParam(name = "courseId") Long courseId){
        List<CmsCourseItem> nodeList = courseItemService.listAll(courseId);
        return CommonResult.success(nodeList);
    }

    @ApiOperation(value = "给某课程增加条目")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsCourseItem cmsCourseItem){
        int count = courseItemService.add(cmsCourseItem);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
