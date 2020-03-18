package com.myproject.admin.dao;

import com.myproject.admin.model.CmsCourseHomeworkRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsCourseHomeworkRelationDao {
    int insertList(@Param("courseHomeworkRelations") List<CmsCourseHomeworkRelation> courseHomeworkRelations);
}
