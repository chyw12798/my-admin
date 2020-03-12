package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CmsCourse implements Serializable {
    private Long id;

    @ApiModelProperty(value = "课程名字")
    private String courseName;

    @ApiModelProperty(value = "课程副标题")
    private String subTitle;

    @ApiModelProperty(value = "课程描述")
    private String desciption;

    @ApiModelProperty(value = "课程主题")
    private String theme;

    @ApiModelProperty(value = "课程类别id")
    private Long courseCategoryId;

    @ApiModelProperty(value = "课程编号")
    private String courseSn;

    @ApiModelProperty(value = "删除状态 0->已删除 1->未删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "课程上架状态 0->为上架 1->已上架")
    private Integer publishStatus;

    @ApiModelProperty(value = "是否是新课程 0->不是 1->是新课程")
    private Integer newStatus;

    @ApiModelProperty(value = "是否主页推荐 0->不推荐 1->推荐")
    private Integer recommendStatus;

    @ApiModelProperty(value = "是否完结：0->已完结，1->未完结")
    private Integer finishStatus;

    @ApiModelProperty(value = "课程审核状态 0->审核中 1->审核通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "课程价格、原价")
    private BigDecimal price;

    @ApiModelProperty(value = "报名学习者人数")
    private Long participantsNum;

    @ApiModelProperty(value = "课程主图集，最好在5张内")
    private String albumPics;

    @ApiModelProperty(value = "课程类别名称")
    private String courseCategoryName;

    @ApiModelProperty(value = "课程备注")
    private String note;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建者")
    private String createMan;

    @ApiModelProperty(value = "课程开始时间")
    private Date startTime;

    @ApiModelProperty(value = "点赞数")
    private Integer praiseNum;

    @ApiModelProperty(value = "主讲老师id，多个老师id以','隔开")
    private String teacherId;

    @ApiModelProperty(value = "所属学校id")
    private Long schoolId;

    @ApiModelProperty(value = "所属班级id")
    private Long classId;

    @ApiModelProperty(value = "课程类别(最低的level)")
    private String categoryName;

    @ApiModelProperty(value = "主讲老师名字")
    private String teacherName;

    @ApiModelProperty(value = "课程详情图")
    private String detailHtml;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Long courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseSn() {
        return courseSn;
    }

    public void setCourseSn(String courseSn) {
        this.courseSn = courseSn;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getParticipantsNum() {
        return participantsNum;
    }

    public void setParticipantsNum(Long participantsNum) {
        this.participantsNum = participantsNum;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseName=").append(courseName);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", desciption=").append(desciption);
        sb.append(", theme=").append(theme);
        sb.append(", courseCategoryId=").append(courseCategoryId);
        sb.append(", courseSn=").append(courseSn);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", newStatus=").append(newStatus);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", finishStatus=").append(finishStatus);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", price=").append(price);
        sb.append(", participantsNum=").append(participantsNum);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", courseCategoryName=").append(courseCategoryName);
        sb.append(", note=").append(note);
        sb.append(", keyword=").append(keyword);
        sb.append(", createTime=").append(createTime);
        sb.append(", createMan=").append(createMan);
        sb.append(", startTime=").append(startTime);
        sb.append(", praiseNum=").append(praiseNum);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", classId=").append(classId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", detailHtml=").append(detailHtml);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}