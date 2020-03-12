package com.myproject.admin.dao;

import com.myproject.admin.model.MasPermission;
import com.myproject.admin.model.MasRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasRoleDao {


    // 返回角色所有权限
    List<MasPermission>  getRolePermissionList(@Param("roleId") Long roleId);


    /**
     * 获取用户角色
     */
    MasRole getAdminRole(@Param("adminId") Long adminId);

}
