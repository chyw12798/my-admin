package com.myproject.admin.mapper;

import com.myproject.admin.model.MasAdminRoleRelation;
import com.myproject.admin.model.MasAdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasAdminRoleRelationMapper {
    long countByExample(MasAdminRoleRelationExample example);

    int deleteByExample(MasAdminRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasAdminRoleRelation record);

    int insertSelective(MasAdminRoleRelation record);

    List<MasAdminRoleRelation> selectByExample(MasAdminRoleRelationExample example);

    MasAdminRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasAdminRoleRelation record, @Param("example") MasAdminRoleRelationExample example);

    int updateByExample(@Param("record") MasAdminRoleRelation record, @Param("example") MasAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(MasAdminRoleRelation record);

    int updateByPrimaryKey(MasAdminRoleRelation record);
}