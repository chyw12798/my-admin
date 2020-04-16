package com.myproject.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dao.MasRoleDao;
import com.myproject.admin.dao.MasRolePemissionDao;
import com.myproject.admin.dto.MasPermissionNode;
import com.myproject.admin.dto.UpdateRolePemissions;
import com.myproject.admin.mapper.MasAdminPermissionRelationMapper;
import com.myproject.admin.mapper.MasAdminRoleRelationMapper;
import com.myproject.admin.mapper.MasRoleMapper;
import com.myproject.admin.mapper.MasRolePermissionRelationMapper;
import com.myproject.admin.model.*;
import com.myproject.admin.service.MasPermissionService;
import com.myproject.admin.service.MasRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasRoleServiceImpl implements MasRoleService {

    @Autowired
    private MasRoleMapper roleMapper;

    @Autowired
    private MasRolePermissionRelationMapper rolePermissionRelationMapper;

    @Autowired
    private MasRolePemissionDao rolePemissionDao;

    @Autowired
    private MasAdminRoleRelationMapper adminRoleRelationMapper;

    @Autowired
    private MasAdminPermissionRelationMapper adminPermissionRelationMapper;

    @Autowired
    private MasPermissionService permissionService;

    @Autowired
    private MasRoleDao roleDao;

    @Override
    public List<MasRole> list(String roleName, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        MasRoleExample example = new MasRoleExample();
        if (StringUtils.isEmpty(roleName)) {
            return roleMapper.selectByExample(example);
        }
        example.createCriteria().andRoleNameLike("%" + roleName + "%");
        return roleMapper.selectByExample(example);
    }

    @Override
    public int add(MasRole masRole) {
        masRole.setCreateTime(new Date());
        masRole.setStatus(1);
        masRole.setAdminCount(0);
        return roleMapper.insert(masRole);
    }

    @Override
    public int update(Long id, MasRole role) {
        MasRoleExample example = new MasRoleExample();
        example.createCriteria().andIdEqualTo(id);
        return roleMapper.updateByExampleSelective(role,example);
    }

    @Override
    public int deleteMany(List<Long> ids) {

        MasRoleExample example = new MasRoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.deleteByExample(example);
    }

    @Override
    public int updatePermission(UpdateRolePemissions updateRolePemissions) {
        // 更新角色权限(权限可以添加，也可以减少)

        Long roleId = updateRolePemissions.getRoleId();
        List<Long> newPermissions = updateRolePemissions.getPermissionList();
        MasRolePermissionRelationExample rolePermissionRelationExample = new MasRolePermissionRelationExample();
        rolePermissionRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<MasRolePermissionRelation> rolePermissionRelationList = rolePermissionRelationMapper.selectByExample(rolePermissionRelationExample);
        if (!CollectionUtils.isEmpty(rolePermissionRelationList)) {
            // 通过java8的流操作获取列表中的字段列表
            // 这里代码太多了，还是用Dao来一行解决吧。
            List<Long> oldPermissonList = rolePermissionRelationList.stream().map(MasRolePermissionRelation::getPermissionId).collect(Collectors.toList());
            List<Long> addPermissions = new ArrayList<>();
            for (Long newPermission : newPermissions) {
                if (!oldPermissonList.contains(newPermission)) {
                    addPermissions.add(newPermission);
                }
            }
            List<Long> deletePermissions = new ArrayList<>();
            for (Long oldPermission : oldPermissonList) {
                if (!newPermissions.contains(oldPermission)) {
                    deletePermissions.add(oldPermission);
                }
            }
            // 添加角色权限
            if (!CollectionUtils.isEmpty(addPermissions)) {
                rolePemissionDao.addRolePemissions(roleId, addPermissions);
            }
            // 删除角色权限
            if (!CollectionUtils.isEmpty(deletePermissions)) {
                MasRolePermissionRelationExample deleteRolePermissionRelationExample = new MasRolePermissionRelationExample();
                deleteRolePermissionRelationExample.createCriteria().andRoleIdEqualTo(roleId)
                        .andPermissionIdIn(deletePermissions);

                rolePermissionRelationMapper.deleteByExample(deleteRolePermissionRelationExample);
                // 删除角色下的用户权限
                updateRoleAdminPermission(roleId, deletePermissions);
            }
        } else {
            rolePemissionDao.addRolePemissions(roleId, newPermissions);
        }
        return 1;

    }

    @Override
    public List<MasPermissionNode> permissionTreeList(Long roleId) {
        // 找出角色所有权限
        List<MasPermission> list = roleDao.getRolePermissionList(roleId);
        List<MasPermission> parentList = list.stream().filter(permission -> permission.getPid().equals(0)).collect(Collectors.toList());

        List<MasPermissionNode> allPermissionNode = new ArrayList<>(parentList.size());
        // 将权限转为树级返回
        for(MasPermission permission:parentList) {
            MasPermissionNode parentpermissionNode = new MasPermissionNode();
            BeanUtils.copyProperties(permissionService,parentpermissionNode);
            // 递归后的结构可以知道参数需要父权限和所有权限列表,最后构造成树Node结构
            List<MasPermissionNode> childPermissionNodeList = permissionService.convert(permission, list);
            parentpermissionNode.setChildren(childPermissionNodeList);
            allPermissionNode.add(parentpermissionNode);
        }
        return allPermissionNode;
    }

    @Override
    public List<MasRole> listAll() {
        return roleMapper.selectByExample(new MasRoleExample());
    }

    private int updateRoleAdminPermission(Long roleId,List<Long> deletePermissions) {

        // 找出角色所有的用户id
        MasAdminRoleRelationExample adminRoleRelationExample = new MasAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<Long> adminIds = adminRoleRelationMapper.selectByExample(adminRoleRelationExample)
                .stream().map(MasAdminRoleRelation::getAdminId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(adminIds)) {
            MasAdminPermissionRelationExample adminPermissionRelationExample = new MasAdminPermissionRelationExample();
            adminPermissionRelationExample.createCriteria().andAdminIdIn(adminIds).andPermissionIdIn(deletePermissions);
            return adminPermissionRelationMapper.deleteByExample(adminPermissionRelationExample);
        }
        return 1;
//        List<Long> adminPermissions = adminPermissionRelationMapper.selectByExample(adminPermissionRelationExample)
//                .stream().map(MasAdminPermissionRelation::getPermissionId).collect(Collectors.toList());


    }
}
