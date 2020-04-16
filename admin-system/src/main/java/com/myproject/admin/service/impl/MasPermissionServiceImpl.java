package com.myproject.admin.service.impl;

import com.myproject.admin.dto.MasPermissionNode;
import com.myproject.admin.mapper.MasPermissionMapper;
import com.myproject.admin.model.MasPermission;
import com.myproject.admin.model.MasPermissionExample;
import com.myproject.admin.service.MasPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasPermissionServiceImpl implements MasPermissionService {

    @Autowired
    private MasPermissionMapper permissionMapper;

    @Override
    public List<MasPermission> listAll() {
        return permissionMapper.selectByExample(new MasPermissionExample());
    }


    @Override
    public int add(MasPermission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int delete(List<Long> ids) {
        MasPermissionExample example = new MasPermissionExample();
        example.createCriteria().andIdIn(ids);
        return permissionMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id, MasPermission permission) {

        permission.setId(id);
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public List<MasPermissionNode> listTree() {
        /**
         * 树级结构需要递归，这时候就考研数据结构的知识了
         */
        List<MasPermission> permissionList = permissionMapper.selectByExample(new MasPermissionExample());
//        permissionList.stream().filter(permission -> permission.getPid().equals(0))
//                // 返回的其实就是pid=0的permission,然后这个permission需要包含自己的子id
//                // 所以需要在permission里加一个子permission,熟悉树形数据结构的也可以知道,
//                // 一个节点类里面还会包含多个节点, 这里的permissionNode权限节点里面也是
//                // 包含多个permissionNode, 所以是一个列表List<MasPermissionNode> childre,
//                // 树级结构的难免会用到递归
//                .map(masPermission -> convert(masPermission,permissionList)).collect(Collectors.toList());


        // 先不用stream操作递归
        List<MasPermission> parentPermissionList = permissionList.stream().filter(permission -> permission.getPid().equals(0)).collect(Collectors.toList());
        // 要返回的List<MasPermissionNode>
        List<MasPermissionNode> permissionNodeList = new ArrayList<>(parentPermissionList.size());
        for (MasPermission parentPermission : parentPermissionList) {
            // 父权限对应的MasPermissionNode
            MasPermissionNode parentpermissionNode = new MasPermissionNode();
            BeanUtils.copyProperties(parentPermission, parentpermissionNode);
            // 递归后的结构可以知道参数需要父权限和所有权限列表,最后构造成树Node结构
            List<MasPermissionNode> childPermissionNodeList = convert(parentPermission, permissionList);
            parentpermissionNode.setChildren(childPermissionNodeList);
            permissionNodeList.add(parentpermissionNode);
        }
        return permissionNodeList;
    }


    // 角色权限也需返回树级权限
    public List<MasPermissionNode> convert(MasPermission parentPermission, List<MasPermission> permissionList) {
        // 某一个父权限对应的node
        MasPermissionNode parentPermissionNode = new MasPermissionNode();
        BeanUtils.copyProperties(parentPermission, parentPermissionNode);
        // 要返回的子权限nodelist
        List<MasPermissionNode> childPermissionNodeList = new ArrayList<>();
        for (MasPermission permission : permissionList) {
            // 看所有的权限的pid是否等于此时进来的parentPermission的id
            if (parentPermission.getPid().equals(parentPermission.getId())) {

                // 现在的权限等于就是父权限其中的一个子节点了
                MasPermissionNode nowPermissionNode = new MasPermissionNode();
                BeanUtils.copyProperties(parentPermission, nowPermissionNode);
                // 添加之前将当前子节点的子节点给设置好,但是这里，子节点是List，所以递归要改一下，要返回List
                nowPermissionNode.setChildren(convert(permission, permissionList));
                // 要添加到list里去，再把子权限list放到父permissionNode里去
                childPermissionNodeList.add(nowPermissionNode);
                // 但是这个节点应该也会有字节点，所以在add之前，将子节点也设置好
            }
        }
        return childPermissionNodeList;
    }

    /**
     * @author chyw1
     * @Description 树级权限版本2
     * @Date 16:36　2020/3/6
     * @Param [parentPermission, permissionList]
     * @return java.util.List<com.myproject.admin.dto.MasPermissionNode>
     **/
    public MasPermissionNode covert2(MasPermission permission,List<MasPermission> permissionList){
        MasPermissionNode node = new MasPermissionNode();
        BeanUtils.copyProperties(permission,node);
        List<MasPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert2(subPermission,permissionList)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(children)){
            node.setChildren(children);
        }
        return node;
    }

}