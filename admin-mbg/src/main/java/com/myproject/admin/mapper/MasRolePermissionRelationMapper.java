package com.myproject.admin.mapper;

import com.myproject.admin.model.MasRolePermissionRelation;
import com.myproject.admin.model.MasRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasRolePermissionRelationMapper {
    long countByExample(MasRolePermissionRelationExample example);

    int deleteByExample(MasRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasRolePermissionRelation record);

    int insertSelective(MasRolePermissionRelation record);

    List<MasRolePermissionRelation> selectByExample(MasRolePermissionRelationExample example);

    MasRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasRolePermissionRelation record, @Param("example") MasRolePermissionRelationExample example);

    int updateByExample(@Param("record") MasRolePermissionRelation record, @Param("example") MasRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(MasRolePermissionRelation record);

    int updateByPrimaryKey(MasRolePermissionRelation record);
}