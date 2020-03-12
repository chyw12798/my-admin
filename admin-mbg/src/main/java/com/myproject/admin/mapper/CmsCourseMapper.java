package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseMapper {
    long countByExample(CmsCourseExample example);

    int deleteByExample(CmsCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourse record);

    int insertSelective(CmsCourse record);

    List<CmsCourse> selectByExampleWithBLOBs(CmsCourseExample example);

    List<CmsCourse> selectByExample(CmsCourseExample example);

    CmsCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourse record, @Param("example") CmsCourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsCourse record, @Param("example") CmsCourseExample example);

    int updateByExample(@Param("record") CmsCourse record, @Param("example") CmsCourseExample example);

    int updateByPrimaryKeySelective(CmsCourse record);

    int updateByPrimaryKeyWithBLOBs(CmsCourse record);

    int updateByPrimaryKey(CmsCourse record);
}