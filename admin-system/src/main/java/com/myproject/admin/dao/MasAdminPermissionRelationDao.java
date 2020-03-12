package com.myproject.admin.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasAdminPermissionRelationDao {

    int insertList(@Param("adminId") Long adminId, @Param("permissionList")List<Long> permissionList);

}
