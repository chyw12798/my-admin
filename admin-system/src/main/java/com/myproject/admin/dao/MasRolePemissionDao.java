package com.myproject.admin.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasRolePemissionDao {

    /**
     * 添加用户权限
     */
    int addRolePemissions(@Param("roleId")Long roleId, @Param("permissionList") List<Long> permissionList);
}
