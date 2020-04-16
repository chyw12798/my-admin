package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class CmsOrderFlow implements Serializable {
    private Long id;

    @ApiModelProperty(value = "交易号")
    private String flowNum;

    @ApiModelProperty(value = "课程ID")
    private Long courseId;

    @ApiModelProperty(value = "支付金额")
    private String payAmount;

    @ApiModelProperty(value = "支付方式")
    private Integer payMethod;

    @ApiModelProperty(value = "购买数量")
    private Integer buyCounts;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "流水编号")
    private String flowSn;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlowSn() {
        return flowSn;
    }

    public void setFlowSn(String flowSn) {
        this.flowSn = flowSn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flowNum=").append(flowNum);
        sb.append(", courseId=").append(courseId);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", buyCounts=").append(buyCounts);
        sb.append(", createTime=").append(createTime);
        sb.append(", flowSn=").append(flowSn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}