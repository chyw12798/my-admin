package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseCateHomeworkRelation;
import com.myproject.admin.model.CmsCourseCateHomeworkRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseCateHomeworkRelationMapper {
    long countByExample(CmsCourseCateHomeworkRelationExample example);

    int deleteByExample(CmsCourseCateHomeworkRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseCateHomeworkRelation record);

    int insertSelective(CmsCourseCateHomeworkRelation record);

    List<CmsCourseCateHomeworkRelation> selectByExample(CmsCourseCateHomeworkRelationExample example);

    CmsCourseCateHomeworkRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseCateHomeworkRelation record, @Param("example") CmsCourseCateHomeworkRelationExample example);

    int updateByExample(@Param("record") CmsCourseCateHomeworkRelation record, @Param("example") CmsCourseCateHomeworkRelationExample example);

    int updateByPrimaryKeySelective(CmsCourseCateHomeworkRelation record);

    int updateByPrimaryKey(CmsCourseCateHomeworkRelation record);
}