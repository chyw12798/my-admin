package com.myproject.admin.mapper;

import com.myproject.admin.model.UmsClass;
import com.myproject.admin.model.UmsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsClassMapper {
    long countByExample(UmsClassExample example);

    int deleteByExample(UmsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsClass record);

    int insertSelective(UmsClass record);

    List<UmsClass> selectByExample(UmsClassExample example);

    UmsClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsClass record, @Param("example") UmsClassExample example);

    int updateByExample(@Param("record") UmsClass record, @Param("example") UmsClassExample example);

    int updateByPrimaryKeySelective(UmsClass record);

    int updateByPrimaryKey(UmsClass record);
}