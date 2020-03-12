package com.myproject.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dao.CmsCourseDao;
import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.mapper.CmsCourseCategoryMapper;
import com.myproject.admin.mapper.CmsCourseMapper;
import com.myproject.admin.model.*;
import com.myproject.admin.service.CmsCourseService;
import com.myproject.admin.service.MasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CmsCourseServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/6 22:03
 * @Version 1.0
 */
@Service
public class CmsCourseServiceImpl implements CmsCourseService {

    @Autowired
    private CmsCourseDao courseDao;

    @Autowired
    private CmsCourseCategoryMapper courseCategoryMapper;

    @Autowired
    private MasUserService masUserService;

    @Autowired
    private CmsCourseMapper cmsCourseMapper;

    // 课程分类
    private static final int COURSE_CATEGORY_LEVEL_ONE = 1;
    private static final int COURSE_CATEGORY_LEVEL_TWO = 2;
    private static final int COURSE_CATEGORY_LEVEL_THREE = 3;

    @Override
    public List<CmsCourse> list(String courseName,Long categoryId,Integer deleteStatus,Integer publishStatus,
                                Integer finishStatus,Integer verifyStatus,String teacherName,Integer pageNum,Integer pageSize) {
        // 此处的类别id查询规则与mall不同，mall只能允许level最低的cate_id查询
        // 这里需要允许，1、2、3级所有级别的查询
        // cms_course表的设计用的cate_ids,存所有的分类级别,如'1,5,7',cate_id=1是5的父分类,5是7的父分类
        List<Long> categoryList = null;
        if (categoryId != null) {
            categoryList = getThreeLevelCategoryIds(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);
        return courseDao.list( courseName, categoryList, deleteStatus, publishStatus, finishStatus, verifyStatus,teacherName);
    }

    /**
     * @author chyw1
     * @Description 传入分类Id，找出第三级的课程分类id
     * @Date 17:22　2020/3/7
     * @Param [categoryId]
     * @return java.util.List<java.lang.Long>
     **/
    public List<Long> getThreeLevelCategoryIds(Long categoryId){
        List<Long> cateIds = new ArrayList<>();
        CmsCourseCategory courseCategory = courseCategoryMapper.selectByPrimaryKey(categoryId);
        if (StringUtils.isEmpty(courseCategory)) {
            throw new RuntimeException("分类查询出错");
        }
//        CmsCourseCategory courseCategory = categories.get(0);
        if (courseCategory.getLevel().equals(COURSE_CATEGORY_LEVEL_THREE)){
            // cate_id是第三级的
            cateIds.add(courseCategory.getId());
        } else if (courseCategory.getLevel().equals(COURSE_CATEGORY_LEVEL_TWO)){
            // cate_id是第二级的，找出第三级的子分类
            List<CmsCourseCategory> courseCategories = courseDao.cateLevelTwoSelectChild(courseCategory.getId());
            if (CollectionUtils.isEmpty(courseCategories)) {
                throw new RuntimeException("分类暂无课程");
            }
            cateIds.addAll(courseCategories.stream().map(CmsCourseCategory::getId).collect(Collectors.toList()));
        } else if (courseCategory.getLevel().equals(COURSE_CATEGORY_LEVEL_ONE)) {
            // cate_id 是第一级的，找出第二级，再找到第三级的子分类
            List<CmsCourseCategory> courseCategories = courseDao.cateLevelThreeSelectChild(courseCategory.getId());
            if(CollectionUtils.isEmpty(courseCategories)) {
                throw new RuntimeException("分类暂无课程");
            }
            cateIds.addAll(courseCategories.stream().map(CmsCourseCategory::getId).collect(Collectors.toList()));
        }
        return cateIds;
    }

    @Override
    public CmsCourseResult getUpdateInfo(Long courseId) {
        return courseDao.getUpdateInfo(courseId);
    }

    @Override
    public int add(CmsCourse course) {
        if(!courseCategoryMapper.selectByPrimaryKey(course.getCourseCategoryId())
                .getLevel().equals(COURSE_CATEGORY_LEVEL_THREE)){
            throw new RuntimeException("所选类别需定位为第三级");
        }
        // TODO 获取当前登录用户接口
        MasAdmin masAdmin = masUserService.getConcurrentAdmin();
        course.setCreateMan(masAdmin.getNickName());
        course.setDeleteStatus(1);
        course.setCreateTime(new Date());
        // 新建课程需等待管理员审核
        course.setVerifyStatus(0);
        course.setPublishStatus(0);
        course.setFinishStatus(0);
        return cmsCourseMapper.insert(course);
    }

    @Override
    public int updateVerifyCourse(List<Long> cmsCourseIds, Integer verifyStatus,String detail) {
        CmsCourseExample cmsCourseExample = new CmsCourseExample();
        cmsCourseExample.createCriteria().andIdIn(cmsCourseIds);
        CmsCourse cmsCourse = new CmsCourse();
        cmsCourse.setVerifyStatus(verifyStatus);
        cmsCourseMapper.updateByExampleSelective(cmsCourse,cmsCourseExample);

        MasAdmin masAdmin = masUserService.getConcurrentAdmin();
        String operateMam = masAdmin.getNickName();
        // 添加审核记录
        List<CmsCourseVerifyRecord> courseVerifyRecordList = new ArrayList<>(cmsCourseIds.size());
        for (Long courseId:cmsCourseIds) {
            CmsCourseVerifyRecord record = new CmsCourseVerifyRecord();
            record.setCourseId(courseId);
            record.setOperateMan(operateMam);
            record.setDetail(detail);
            record.setOperateTime(new Date());
            record.setVerifyStatus(verifyStatus);
        }
        courseDao.bacthUpdateVerifyCourse(courseVerifyRecordList);

        return 1;
    }

    @Override
    public int bathPublishCourse(List<Long> cmsCourseId, Integer publishStatus) {

        CmsCourse cmsCourse = new CmsCourse();
        cmsCourse.setPublishStatus(publishStatus);

        CmsCourseExample example = new CmsCourseExample();
        example.createCriteria().andIdIn(cmsCourseId);
        return cmsCourseMapper.updateByExampleSelective(cmsCourse,example);
    }

    @Override
    public int bathDeleteCourse(List<Long> cmsCourseId) {
        CmsCourse cmsCourse = new CmsCourse();
        cmsCourse.setDeleteStatus(0);

        CmsCourseExample example = new CmsCourseExample();
        example.createCriteria().andIdIn(cmsCourseId);
        return cmsCourseMapper.updateByExampleSelective(cmsCourse,example);
    }
}
