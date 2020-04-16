package com.myproject.admin.dto;

import com.myproject.admin.model.MasAdmin;

/**
 * @ClassName MasAdminInfo
 * @Description TODO
 * @Author chyw1
 * @Date 2020/4/4 19:04
 * @Version 1.0
 */
public class MasAdminInfo extends MasAdmin {

    private Long roleId;

    private String role;

    private String createTime;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
