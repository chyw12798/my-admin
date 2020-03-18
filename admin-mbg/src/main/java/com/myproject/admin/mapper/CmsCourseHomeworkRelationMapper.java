package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseHomeworkRelation;
import com.myproject.admin.model.CmsCourseHomeworkRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseHomeworkRelationMapper {
    long countByExample(CmsCourseHomeworkRelationExample example);

    int deleteByExample(CmsCourseHomeworkRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseHomeworkRelation record);

    int insertSelective(CmsCourseHomeworkRelation record);

    List<CmsCourseHomeworkRelation> selectByExample(CmsCourseHomeworkRelationExample example);

    CmsCourseHomeworkRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseHomeworkRelation record, @Param("example") CmsCourseHomeworkRelationExample example);

    int updateByExample(@Param("record") CmsCourseHomeworkRelation record, @Param("example") CmsCourseHomeworkRelationExample example);

    int updateByPrimaryKeySelective(CmsCourseHomeworkRelation record);

    int updateByPrimaryKey(CmsCourseHomeworkRelation record);
}