package com.myproject.admin.service;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dto.MasPermissionNode;
import com.myproject.admin.dto.UpdateRolePemissions;
import com.myproject.admin.model.MasRole;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MasRoleService {

    List<MasRole> list(String roleName, Integer pageNum, Integer pageSize);

    int add(MasRole masRole);

    int update(Long id, MasRole role);

    int deleteMany(List<Long> ids);

    @Transactional
    int updatePermission( UpdateRolePemissions updateRolePemissions);

    List<MasPermissionNode> permissionTreeList(Long roleId);
}
