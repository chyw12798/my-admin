package com.myproject.admin.dto;

import com.myproject.admin.model.MasPermission;

import java.util.List;

/**
 * @ClassName UpdateAdminRoleParam
 * @Description 修改用户角色参数(包括修改权限)
 * @Author chyw1
 * @Date 2020/3/12 21:17
 * @Version 1.0
 */
public class UpdateAdminRoleParam {

    private Long masAdminId;

    private Long masRoleId;

    private List<Long> masPermissionIds;

    public Long getMasAdminId() {
        return masAdminId;
    }

    public void setMasAdminId(Long masAdminId) {
        this.masAdminId = masAdminId;
    }

    public Long getMasRoleId() {
        return masRoleId;
    }

    public void setMasRoleId(Long masRoleId) {
        this.masRoleId = masRoleId;
    }

    public List<Long> getMasPermissions() {
        return masPermissionIds;
    }

    public void setMasPermissions(List<Long> masPermissionIds) {
        this.masPermissionIds = masPermissionIds;
    }
}
