package com.myproject.admin.mapper;

import com.myproject.admin.model.UmsSchoole;
import com.myproject.admin.model.UmsSchooleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsSchooleMapper {
    long countByExample(UmsSchooleExample example);

    int deleteByExample(UmsSchooleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsSchoole record);

    int insertSelective(UmsSchoole record);

    List<UmsSchoole> selectByExample(UmsSchooleExample example);

    UmsSchoole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsSchoole record, @Param("example") UmsSchooleExample example);

    int updateByExample(@Param("record") UmsSchoole record, @Param("example") UmsSchooleExample example);

    int updateByPrimaryKeySelective(UmsSchoole record);

    int updateByPrimaryKey(UmsSchoole record);
}