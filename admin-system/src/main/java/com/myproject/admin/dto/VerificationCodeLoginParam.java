package com.myproject.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName VerificationCodeLoginParam
 * @Description 验证码登录的参数
 * @Author chyw1
 * @Date 2020/3/12 14:45
 * @Version 1.0
 */
@Getter
@Setter
public class VerificationCodeLoginParam {
    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "验证码", required = true)
    @NotEmpty(message = "验证码不能为空")
    private String verificationCode;

}
