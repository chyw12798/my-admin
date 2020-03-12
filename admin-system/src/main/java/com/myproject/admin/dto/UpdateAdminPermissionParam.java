package com.myproject.admin.dto;

import java.util.List;

/**
 * @ClassName UpdateAdminPermissionParam
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/12 22:26
 * @Version 1.0
 */
public class UpdateAdminPermissionParam {
    private Long adminId;
    private List<Long> permissionIds;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
