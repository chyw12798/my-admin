package com.myproject.admin.service;

import com.myproject.admin.dto.CmsCourseCategoryHomeworkParam;
import com.myproject.admin.dto.CmsCourseCategoryNode;
import com.myproject.admin.model.CmsCourseCategory;

import java.util.List;

public interface CmsCourseCategoryService {
    int add(CmsCourseCategory cmsCourseCategory);

    List<CmsCourseCategoryNode> treeList(Integer pageNum,Integer pageSize);

    int addHomework(CmsCourseCategoryHomeworkParam courseCategoryHomeworkParam);

    List<CmsCourseCategoryNode> getParentCateList();
}
