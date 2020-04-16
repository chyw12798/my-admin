package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CmsCourseCart implements Serializable {
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "课程ID")
    private Long courseId;

    @ApiModelProperty(value = "课程数量（默认为1）")
    private Long quantity;

    @ApiModelProperty(value = "课程在购物车的价格")
    private BigDecimal price;

    @ApiModelProperty(value = "课程名字")
    private String courseName;

    @ApiModelProperty(value = "课程主图")
    private String coursePic;

    @ApiModelProperty(value = "课程副标题")
    private String coueseSubTitle;

    @ApiModelProperty(value = "课程编号")
    private String courseSn;

    @ApiModelProperty(value = "用户名字")
    private String userName;

    @ApiModelProperty(value = "课程分类")
    private Long courseCatogeryId;

    @ApiModelProperty(value = "课程加入购物车的时间(创建时间)")
    private Date createTime;

    @ApiModelProperty(value = "购物车课程更新时间")
    private Date modifyTime;

    @ApiModelProperty(value = "是否删除:0->未删除，1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "主讲老师id")
    private Long teacherId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public String getCoueseSubTitle() {
        return coueseSubTitle;
    }

    public void setCoueseSubTitle(String coueseSubTitle) {
        this.coueseSubTitle = coueseSubTitle;
    }

    public String getCourseSn() {
        return courseSn;
    }

    public void setCourseSn(String courseSn) {
        this.courseSn = courseSn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getCourseCatogeryId() {
        return courseCatogeryId;
    }

    public void setCourseCatogeryId(Long courseCatogeryId) {
        this.courseCatogeryId = courseCatogeryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", courseName=").append(courseName);
        sb.append(", coursePic=").append(coursePic);
        sb.append(", coueseSubTitle=").append(coueseSubTitle);
        sb.append(", courseSn=").append(courseSn);
        sb.append(", userName=").append(userName);
        sb.append(", courseCatogeryId=").append(courseCatogeryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}