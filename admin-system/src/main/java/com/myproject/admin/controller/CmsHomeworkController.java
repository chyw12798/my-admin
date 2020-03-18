package com.myproject.admin.controller;

import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.model.CmsCourseCategory;
import com.myproject.admin.model.CmsHomework;
import com.myproject.admin.model.CmsHomeworkCate;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.service.CmsHomeworkService;
import com.myproject.admin.service.MasUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CmsHomeworkController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 9:07
 * @Version 1.0
 */
@Controller
@Api(tags = "CmsHomeworkController", description = "后台作业管理")
@RequestMapping("/homework")
public class CmsHomeworkController {

    @Autowired
    private CmsHomeworkService homeworkService;
    @Autowired
    private MasUserService userService;


    @ApiOperation(value = "添加作业")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsHomework CmsHomework){
        MasAdmin masAdmin = userService.getConcurrentAdmin();
        CmsHomework.setCreater(masAdmin.getNickName());
        CmsHomework.setStatus(1);
        int count = homeworkService.add(CmsHomework);

        if (count>0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "添加作业题型")
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsHomeworkCate homeworkCate){
        int count = homeworkService.addCategory(homeworkCate);

        if (count>0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "查询作业")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        List<CmsHomework> cmsHomeworkList = homeworkService.list(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(cmsHomeworkList));
    }

    @ApiOperation(value = "更新作业")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult list(@RequestHeader(name = "Authorization")String myHeader,
                             @RequestBody CmsHomework homework){
        int count = homeworkService.update(homework);

        return CommonResult.success(count);
    }
}
