package com.myproject.admin.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName CmsCourseHomeworkParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 9:08
 * @Version 1.0
 */
public class CmsCourseHomeworkParam {

    @ApiModelProperty(value = "课程id", required = true)
    @NotEmpty(message = "课程id不能为空")
    private Long courseId;
    @ApiModelProperty(value = "作业列表", required = true)
    @NotEmpty(message = "作业列表不能为空")
    private List<Long> homeworkList;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<Long> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Long> homeworkList) {
        this.homeworkList = homeworkList;
    }
}
