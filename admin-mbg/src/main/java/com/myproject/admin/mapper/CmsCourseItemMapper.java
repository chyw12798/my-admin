package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseItem;
import com.myproject.admin.model.CmsCourseItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseItemMapper {
    long countByExample(CmsCourseItemExample example);

    int deleteByExample(CmsCourseItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseItem record);

    int insertSelective(CmsCourseItem record);

    List<CmsCourseItem> selectByExample(CmsCourseItemExample example);

    CmsCourseItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseItem record, @Param("example") CmsCourseItemExample example);

    int updateByExample(@Param("record") CmsCourseItem record, @Param("example") CmsCourseItemExample example);

    int updateByPrimaryKeySelective(CmsCourseItem record);

    int updateByPrimaryKey(CmsCourseItem record);
}