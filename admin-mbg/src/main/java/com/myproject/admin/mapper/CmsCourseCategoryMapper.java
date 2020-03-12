package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseCategory;
import com.myproject.admin.model.CmsCourseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseCategoryMapper {
    long countByExample(CmsCourseCategoryExample example);

    int deleteByExample(CmsCourseCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseCategory record);

    int insertSelective(CmsCourseCategory record);

    List<CmsCourseCategory> selectByExample(CmsCourseCategoryExample example);

    CmsCourseCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseCategory record, @Param("example") CmsCourseCategoryExample example);

    int updateByExample(@Param("record") CmsCourseCategory record, @Param("example") CmsCourseCategoryExample example);

    int updateByPrimaryKeySelective(CmsCourseCategory record);

    int updateByPrimaryKey(CmsCourseCategory record);
}