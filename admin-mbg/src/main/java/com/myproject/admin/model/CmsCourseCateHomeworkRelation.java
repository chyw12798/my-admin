package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CmsCourseCateHomeworkRelation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "课程种类id")
    private Long courseCateId;

    @ApiModelProperty(value = "作业id")
    private Long homeworkId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseCateId() {
        return courseCateId;
    }

    public void setCourseCateId(Long courseCateId) {
        this.courseCateId = courseCateId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseCateId=").append(courseCateId);
        sb.append(", homeworkId=").append(homeworkId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}