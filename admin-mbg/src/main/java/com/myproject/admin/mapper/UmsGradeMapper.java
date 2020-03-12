package com.myproject.admin.mapper;

import com.myproject.admin.model.UmsGrade;
import com.myproject.admin.model.UmsGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsGradeMapper {
    long countByExample(UmsGradeExample example);

    int deleteByExample(UmsGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsGrade record);

    int insertSelective(UmsGrade record);

    List<UmsGrade> selectByExample(UmsGradeExample example);

    UmsGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsGrade record, @Param("example") UmsGradeExample example);

    int updateByExample(@Param("record") UmsGrade record, @Param("example") UmsGradeExample example);

    int updateByPrimaryKeySelective(UmsGrade record);

    int updateByPrimaryKey(UmsGrade record);
}