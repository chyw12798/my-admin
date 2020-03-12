package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class CmsCourseItem implements Serializable {
    private Long id;

    @ApiModelProperty(value = "课程条目名字")
    private String name;

    @ApiModelProperty(value = "所属课程id")
    private Long courseId;

    @ApiModelProperty(value = "课程条目是否上完 0->未上, 1->已上")
    private Integer finishStatus;

    @ApiModelProperty(value = "录播回放地址")
    private String recodeUrl;

    @ApiModelProperty(value = "录播时长")
    private Integer recodeMinute;

    @ApiModelProperty(value = "课程条目编码")
    private String itemSn;

    @ApiModelProperty(value = "课程条目主讲老师")
    private Integer teacherId;

    @ApiModelProperty(value = "直播时间")
    private Date recodeTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getRecodeUrl() {
        return recodeUrl;
    }

    public void setRecodeUrl(String recodeUrl) {
        this.recodeUrl = recodeUrl;
    }

    public Integer getRecodeMinute() {
        return recodeMinute;
    }

    public void setRecodeMinute(Integer recodeMinute) {
        this.recodeMinute = recodeMinute;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getRecodeTime() {
        return recodeTime;
    }

    public void setRecodeTime(Date recodeTime) {
        this.recodeTime = recodeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", courseId=").append(courseId);
        sb.append(", finishStatus=").append(finishStatus);
        sb.append(", recodeUrl=").append(recodeUrl);
        sb.append(", recodeMinute=").append(recodeMinute);
        sb.append(", itemSn=").append(itemSn);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", recodeTime=").append(recodeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}