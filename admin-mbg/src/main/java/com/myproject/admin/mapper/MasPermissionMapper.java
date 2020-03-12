package com.myproject.admin.mapper;

import com.myproject.admin.model.MasPermission;
import com.myproject.admin.model.MasPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasPermissionMapper {
    long countByExample(MasPermissionExample example);

    int deleteByExample(MasPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasPermission record);

    int insertSelective(MasPermission record);

    List<MasPermission> selectByExample(MasPermissionExample example);

    MasPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasPermission record, @Param("example") MasPermissionExample example);

    int updateByExample(@Param("record") MasPermission record, @Param("example") MasPermissionExample example);

    int updateByPrimaryKeySelective(MasPermission record);

    int updateByPrimaryKey(MasPermission record);
}