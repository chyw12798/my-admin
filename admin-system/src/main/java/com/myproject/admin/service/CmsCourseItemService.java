package com.myproject.admin.service;

import com.myproject.admin.model.CmsCourseItem;

import java.util.List;

public interface CmsCourseItemService {
    List<CmsCourseItem> listAll(Long courseId);

    int add(CmsCourseItem cmsCourseItem);
}
