package com.myproject.admin.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName CmsCourseCategoryHomeworkParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 18:06
 * @Version 1.0
 */
public class CmsCourseCategoryHomeworkParam {

    @ApiModelProperty(value = "课程分类id", required = true)
    @NotEmpty(message = "课程分类id不能为空")
    private Long courseCategoryId;
    @ApiModelProperty(value = "作业列表", required = true)
    @NotEmpty(message = "作业列表不能为空")
    private List<Long> homeworkList;

    public Long getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Long courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public List<Long> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Long> homeworkList) {
        this.homeworkList = homeworkList;
    }
}
