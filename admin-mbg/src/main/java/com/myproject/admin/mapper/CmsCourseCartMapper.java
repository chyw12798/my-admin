package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseCart;
import com.myproject.admin.model.CmsCourseCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseCartMapper {
    long countByExample(CmsCourseCartExample example);

    int deleteByExample(CmsCourseCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseCart record);

    int insertSelective(CmsCourseCart record);

    List<CmsCourseCart> selectByExample(CmsCourseCartExample example);

    CmsCourseCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseCart record, @Param("example") CmsCourseCartExample example);

    int updateByExample(@Param("record") CmsCourseCart record, @Param("example") CmsCourseCartExample example);

    int updateByPrimaryKeySelective(CmsCourseCart record);

    int updateByPrimaryKey(CmsCourseCart record);
}