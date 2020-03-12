package com.myproject.admin.service;

import com.myproject.admin.dto.MasPermissionNode;
import com.myproject.admin.model.MasPermission;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MasPermissionService {

    List<MasPermission> listAll();

    /**
     * 树级列表
     * @return
     */
    List<MasPermissionNode> listTree();

    /**
     * @author chyw1
     * @Description 添加权限
     * @Date 15:33　2020/3/6
     * @Param [permission]
     * @return int
     **/
    int add (MasPermission permission);

    int delete( List<Long> ids);

    /**
     * @author chyw1
     * @Description 根据id修改权限
     * @Date 15:40　2020/3/6
     * @Param [id, permission]
     * @return int
     **/
    int update( Long id,  MasPermission permission);

    /**
     * @author chyw1
     * @Description 权限树级递归方法
     * @Date 16:34　2020/3/6
     * @Param [parentPermission, permissionList]
     * @return java.util.List<com.myproject.admin.dto.MasPermissionNode>
     **/
    List<MasPermissionNode> convert(MasPermission parentPermission, List<MasPermission> permissionList);
}
