package com.myproject.admin.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName UpdatePasswordParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 19:03
 * @Version 1.0
 */
public class UpdatePasswordParam {

    @ApiModelProperty(value = "手机号",required = true)
    @NotEmpty(message = "手机号不能为空")
    private String phone;


    @ApiModelProperty(value = "新密码",required = true)
    @NotEmpty(message = "密码不能为空")
    private String newPassword;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
