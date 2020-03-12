package com.myproject.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class UpdateRolePemissions {

    @ApiModelProperty(value = "角色Id", required = true)
    @NotEmpty(message = "角色Id不能为空")
    Long RoleId;

    @ApiModelProperty(value = "前端返回来的权限列表", required = true)
    @NotEmpty(message = "不能为空")
    List<Long> permissionList;

}
