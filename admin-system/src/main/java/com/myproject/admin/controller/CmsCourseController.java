package com.myproject.admin.controller;

import com.myproject.admin.api.CommonPage;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.CmsCourseHomeworkParam;
import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.service.CmsCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MasCourseController
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/6 21:37
 * @Version 1.0
 */
@Controller
@Api(tags = "MasCourseController", description = "后台课程管理")
@RequestMapping("/course")
public class CmsCourseController {


    @Autowired
    private CmsCourseService courseService;
    @ApiOperation(value = "主页面课程列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestParam(value = "courseName",required = false) String courseName,
                             @RequestParam(value = "categoryId",required = false) Long categoryId,
                             @RequestParam(value = "deleteStatus",required = false) Integer deleteStatus,
                             @RequestParam(value = "publishStatus",required = false) Integer publishStatus,
                             @RequestParam(value = "finishStatus",required = false) Integer finishStatus,
                             @RequestParam(value = "verifyStatus",required = false) Integer verifyStatus,
                             @RequestParam(value = "teacherName",required = false) String teacherName,
                             @RequestParam(value = "pageNum",required = false) Integer pageNum,
                             @RequestParam(value = "pageSize",required = false) Integer pageSize){
        // 需要展示的课程信息:名字、主页面图片、课程描述...
        // 直接全部返回吧，写前端了再看
        List<CmsCourse> courseList = courseService.list(courseName,categoryId,deleteStatus,publishStatus,finishStatus,verifyStatus,
                teacherName,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(courseList));

    }

    @ApiOperation(value = "编辑课程,返回某个课程详细内容")
    @RequestMapping(value = "/info/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(@PathVariable("id") Long id){
        CmsCourseResult info = courseService.getUpdateInfo(id);

        return CommonResult.success(info);
    }

    @ApiOperation(value = "新建课程")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestHeader(name = "Authorization")String myHeader,
                            @RequestBody CmsCourse course) {
        int count = courseService.add(course);
        if (count > 0) {
            return CommonResult.success("新建课程成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "批量审核课程(通过或不通过)")
    @RequestMapping(value = "/updateVerifyCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateVerifyCourse(@RequestHeader(name = "Authorization")String myHeader,
                                           @RequestParam("cmsCourseIds") List<Long> cmsCourseIds,
                                           @RequestParam("verifyStatus") Integer verifyStatus,
                                           @RequestParam("detail") String detail) {
        int count = courseService.updateVerifyCourse(cmsCourseIds,verifyStatus,detail);
        return CommonResult.success(count);
    }

    @ApiOperation(value = "批量上下架课程")
    @RequestMapping(value = "/bathPublishCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult bathPublishCourse(@RequestHeader(name = "Authorization")String myHeader,
                                          @RequestParam("cmsCourseIds") List<Long> cmsCourseId,
                                          @RequestParam("publishStatus")Integer publishStatus) {

        int count = courseService.bathPublishCourse(cmsCourseId,publishStatus);
        if (count > 0 ) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation(value = "批量删除课程")
    @RequestMapping(value = "/bathDeleteCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult bathDeleteCourse(@RequestHeader(name = "Authorization")String myHeader,
                                         @RequestParam("cmsCourseIds") List<Long> cmsCourseId) {

        int count = courseService.bathDeleteCourse(cmsCourseId);
        if (count > 0 ) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "给指定课程批量添加作业")
    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addHomework(@RequestHeader(name = "Authorization")String myHeader,
                                    @RequestBody CmsCourseHomeworkParam courseHomeworkParam) {

        int count = courseService.addHomework(courseHomeworkParam);
        if (count > 0 ) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
