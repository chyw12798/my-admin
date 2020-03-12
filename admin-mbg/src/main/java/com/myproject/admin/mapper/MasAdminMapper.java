package com.myproject.admin.mapper;

import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.model.MasAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasAdminMapper {
    long countByExample(MasAdminExample example);

    int deleteByExample(MasAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MasAdmin record);

    int insertSelective(MasAdmin record);

    List<MasAdmin> selectByExample(MasAdminExample example);

    MasAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MasAdmin record, @Param("example") MasAdminExample example);

    int updateByExample(@Param("record") MasAdmin record, @Param("example") MasAdminExample example);

    int updateByPrimaryKeySelective(MasAdmin record);

    int updateByPrimaryKey(MasAdmin record);
}