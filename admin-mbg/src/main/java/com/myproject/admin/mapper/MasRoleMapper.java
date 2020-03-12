package com.myproject.admin.mapper;

import com.myproject.admin.model.MasRole;
import com.myproject.admin.model.MasRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasRoleMapper {
    long countByExample(MasRoleExample example);

    int deleteByExample(MasRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasRole record);

    int insertSelective(MasRole record);

    List<MasRole> selectByExample(MasRoleExample example);

    MasRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasRole record, @Param("example") MasRoleExample example);

    int updateByExample(@Param("record") MasRole record, @Param("example") MasRoleExample example);

    int updateByPrimaryKeySelective(MasRole record);

    int updateByPrimaryKey(MasRole record);
}