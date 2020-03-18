package com.myproject.admin.service;

import com.myproject.admin.model.CmsHomework;
import com.myproject.admin.model.CmsHomeworkCate;

import java.util.List;

public interface CmsHomeworkService {
    int add(CmsHomework cmsHomework);

    List<CmsHomework> list(Integer pageNum,Integer pageSize);

    int addCategory(CmsHomeworkCate homeworkCate);

    int update(CmsHomework homework);
}
