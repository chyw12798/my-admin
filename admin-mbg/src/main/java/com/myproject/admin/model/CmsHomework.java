package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CmsHomework implements Serializable {
    private Long id;

    @ApiModelProperty(value = "作业种类id")
    private Long cateId;

    @ApiModelProperty(value = "参考答案")
    private String rightKey;

    @ApiModelProperty(value = "状态：0->禁用,1->启用")
    private Integer status;

    @ApiModelProperty(value = "创建者")
    private String creater;

    @ApiModelProperty(value = "问题名字")
    private String questionName;

    @ApiModelProperty(value = "选项内容")
    private String optionContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getRightKey() {
        return rightKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cateId=").append(cateId);
        sb.append(", rightKey=").append(rightKey);
        sb.append(", status=").append(status);
        sb.append(", creater=").append(creater);
        sb.append(", questionName=").append(questionName);
        sb.append(", optionContent=").append(optionContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}