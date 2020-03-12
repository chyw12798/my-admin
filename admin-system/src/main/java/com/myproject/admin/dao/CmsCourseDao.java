package com.myproject.admin.dao;

import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseCategory;
import com.myproject.admin.model.CmsCourseVerifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsCourseDao {

    List<CmsCourse>  list(@Param("courseName") String courseName,@Param("categoryIdList") List<Long> categoryList
            ,@Param("deleteStatus") Integer deleteStatus,@Param("publishStatus") Integer publishStatus,
                          @Param("finishStatus")Integer finishStatus, @Param("verifyStatus")Integer verifyStatus,
                          @Param("teacherName")String teacherName);

    /**
     * @author chyw1
     * @Description 获取编辑课程返回的信息，待扩展
     * @Date 12:25　2020/3/7
     * @Param [id]
     * @return com.myproject.admin.dto.CmsCourseResult
     **/
    CmsCourseResult getUpdateInfo(Long id);

    /**
     * @author chyw1
     * @Description 分类级别是第二级的，查找子分类
     * @Date 16:58　2020/3/7
     * @Param [cateId]
     * @return java.util.List<com.myproject.admin.model.CmsCourseCategory>
     **/
    List<CmsCourseCategory> cateLevelTwoSelectChild(@Param("cateId") Long cateId);

    /**
     * @author chyw1
     * @Description
     * @Date 17:01　2020/3/7
     * @Param [id]
     * @return java.util.List<com.myproject.admin.model.CmsCourseCategory>
     **/
    List<CmsCourseCategory> cateLevelThreeSelectChild(Long cateId);

    int bacthUpdateVerifyCourse(@Param("list") List<CmsCourseVerifyRecord> list);
}
