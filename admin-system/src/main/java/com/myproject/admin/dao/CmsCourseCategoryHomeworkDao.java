package com.myproject.admin.dao;

import com.myproject.admin.model.CmsCourseCateHomeworkRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsCourseCategoryHomeworkDao {
    int insertList(@Param("list") List<CmsCourseCateHomeworkRelation> courseCateHomeworkRelations);
}
