package com.myproject.admin.mapper;

import com.myproject.admin.model.MasAdminPermissionRelation;
import com.myproject.admin.model.MasAdminPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasAdminPermissionRelationMapper {
    long countByExample(MasAdminPermissionRelationExample example);

    int deleteByExample(MasAdminPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasAdminPermissionRelation record);

    int insertSelective(MasAdminPermissionRelation record);

    List<MasAdminPermissionRelation> selectByExample(MasAdminPermissionRelationExample example);

    MasAdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasAdminPermissionRelation record, @Param("example") MasAdminPermissionRelationExample example);

    int updateByExample(@Param("record") MasAdminPermissionRelation record, @Param("example") MasAdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(MasAdminPermissionRelation record);

    int updateByPrimaryKey(MasAdminPermissionRelation record);
}