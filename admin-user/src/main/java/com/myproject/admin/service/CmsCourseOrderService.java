package com.myproject.admin.service;

import com.myproject.admin.model.CmsCourse;

public interface CmsCourseOrderService {
    int add(Long cmsCourseId);

    void showCourse(Long courseId);
}
