package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CmsCourseOrder implements Serializable {
    private Long id;

    @ApiModelProperty(value = "订单课程id")
    private Long courseId;

    @ApiModelProperty(value = "下单用户")
    private Long userId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "总金额(不使用优惠金额)")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "实际支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal conponAmount;

    @ApiModelProperty(value = "支付方式: 0->未支付 1->微信 2->支付宝")
    private Integer payType;

    @ApiModelProperty(value = "订单状态： 1->已创建未支付，2->已支付, 4->无效订单,5->已关闭")
    private Integer status;

    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    @ApiModelProperty(value = "删除状态: 0->已删除 1->未删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    @ApiModelProperty(value = "课程名字")
    private String courseName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getConponAmount() {
        return conponAmount;
    }

    public void setConponAmount(BigDecimal conponAmount) {
        this.conponAmount = conponAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", userId=").append(userId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", conponAmount=").append(conponAmount);
        sb.append(", payType=").append(payType);
        sb.append(", status=").append(status);
        sb.append(", payTime=").append(payTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", note=").append(note);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", courseName=").append(courseName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}