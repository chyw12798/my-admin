package com.myproject.admin.dto;

import com.myproject.admin.model.MasPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 权限树级结构类
 * 权限树级结构最多三级
 */

public class MasPermissionNode extends MasPermission {
    @Getter
    @Setter
    List<MasPermissionNode> children;
}
