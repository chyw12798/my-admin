package com.myproject.admin.dao;

import com.myproject.admin.model.MasPermission;
import com.myproject.admin.model.MasRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasAdminDao {
    /**
     * 获取用户权限,包括+-权限
     * 这里可以测试一下
     * 暂无+-权限
     */
    List<MasPermission> getAdminPermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户角色，这里的方法怎么老是报错！！bound statement
     */
    MasRole getAdminRole(@Param("adminId") Long adminId);

}
