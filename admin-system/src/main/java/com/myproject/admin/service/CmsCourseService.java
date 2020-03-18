package com.myproject.admin.service;

import com.myproject.admin.dto.CmsCourseHomeworkParam;
import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.model.CmsCourse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CmsCourseService {
    List<CmsCourse> list(String courseName,Long categoryId,Integer deleteStatus,Integer publishStatus,
                         Integer finishStatus,Integer verifyStatus,String  teacherName,Integer pageNum,Integer pageSize);
    CmsCourseResult getUpdateInfo(Long id);

    int add(CmsCourse course);

    @Transactional
    int updateVerifyCourse( List<Long> cmsCourseIds,Integer verifyStatus,String detail);

    int bathPublishCourse( List<Long> cmsCourseId,Integer publishStatus);

    int bathDeleteCourse( List<Long> cmsCourseId);

    int addHomework(CmsCourseHomeworkParam courseHomeworkParam);
}
