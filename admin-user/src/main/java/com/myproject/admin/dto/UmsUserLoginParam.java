package com.myproject.admin.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName UmsUserLoginParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 10:48
 * @Version 1.0
 */
public class UmsUserLoginParam {

    @ApiModelProperty(value = "账号",required = true)
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
