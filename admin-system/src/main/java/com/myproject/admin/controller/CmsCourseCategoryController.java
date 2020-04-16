package com.myproject.admin.controller;

import com.github.pagehelper.PageHelper;
import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.CmsCourseCategoryHomeworkParam;
import com.myproject.admin.dto.CmsCourseCategoryNode;
import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.model.CmsCourseCategory;
import com.myproject.admin.service.CmsCourseCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CmsCourseCategoryController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 9:24
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsCourseCategoryController", description = "后台课程分类管理")
@RequestMapping("/courseCategory")
public class CmsCourseCategoryController {

    @Autowired
    private CmsCourseCategoryService courseCategoryService;

    // 查询树级分类
    @ApiOperation(value = "查询分类列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult treeList(@RequestHeader(name = "Authorization")String myHeader,
                                 @RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                 @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize){

        List<CmsCourseCategoryNode> nodeList = courseCategoryService.treeList(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(nodeList));
    }


    @ApiOperation(value = "添加分类")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsCourseCategory cmsCourseCategory){
        int count = courseCategoryService.add(cmsCourseCategory);

        if (count>0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "给课程分类批量添加作业")
    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addHomework(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsCourseCategoryHomeworkParam courseCategoryHomeworkParam){
        int count = courseCategoryService.addHomework(courseCategoryHomeworkParam);

        if (count>0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "父级分类列表")
    @RequestMapping(value = "/getParentCateList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getParentCateList(@RequestHeader(name = "Authorization")String myHeader){
        List<CmsCourseCategoryNode> list = courseCategoryService.getParentCateList();
        return CommonResult.success(list);
    }

}
