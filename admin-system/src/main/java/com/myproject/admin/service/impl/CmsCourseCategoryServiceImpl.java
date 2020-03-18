package com.myproject.admin.service.impl;

import com.myproject.admin.dao.CmsCourseCategoryHomeworkDao;
import com.myproject.admin.dto.CmsCourseCategoryHomeworkParam;
import com.myproject.admin.dto.CmsCourseCategoryNode;
import com.myproject.admin.mapper.CmsCourseCategoryMapper;
import com.myproject.admin.model.CmsCourseCateHomeworkRelation;
import com.myproject.admin.model.CmsCourseCategory;
import com.myproject.admin.model.CmsCourseCategoryExample;
import com.myproject.admin.service.CmsCourseCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ClassName CmsCourseCategoryServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 9:29
 * @Version 1.0
 */
@Service
public class CmsCourseCategoryServiceImpl implements CmsCourseCategoryService {

    @Autowired
    private CmsCourseCategoryMapper courseCategoryMapper;

    @Autowired
    private CmsCourseCategoryHomeworkDao courseCategoryHomeworkDao;

    @Override
    public int getUpdateInfo(CmsCourseCategory cmsCourseCategory) {
        return courseCategoryMapper.insert(cmsCourseCategory);
    }

    @Override
    public List<CmsCourseCategoryNode> treeList() {

        List<CmsCourseCategory> courseCategoryList = courseCategoryMapper.selectByExample(new CmsCourseCategoryExample());
        if (!CollectionUtils.isEmpty(courseCategoryList)) {
            return courseCategoryList.stream().filter(cmsCourseCategory -> cmsCourseCategory.getPid().equals(0L))
                    .map(cmsCourseCategory -> convert(cmsCourseCategory,courseCategoryList)).collect(Collectors.toList());
        }
        return null;
    }


    private CmsCourseCategoryNode convert(CmsCourseCategory cmsCourseCategory, List<CmsCourseCategory> courseCategoryList) {

        CmsCourseCategoryNode node = new CmsCourseCategoryNode();
        BeanUtils.copyProperties(cmsCourseCategory, node);
        List<CmsCourseCategoryNode> childCourseCategoryList = courseCategoryList.stream()
                .filter(childCourseCategory -> childCourseCategory.getPid().equals(cmsCourseCategory.getId()))
                .map(childCourseCategory -> convert(childCourseCategory, courseCategoryList)).collect(Collectors.toList());
        node.setChildren(childCourseCategoryList);
        return node;
    }


    @Override
    public int addHomework(CmsCourseCategoryHomeworkParam courseCategoryHomeworkParam) {
        List<Long> homeworkList = courseCategoryHomeworkParam.getHomeworkList();
        Long courseCategoryId = courseCategoryHomeworkParam.getCourseCategoryId();
        List<CmsCourseCateHomeworkRelation> courseCateHomeworkRelations = new ArrayList<>(homeworkList.size());
        for (Long homeworkId: homeworkList) {
            CmsCourseCateHomeworkRelation relation = new CmsCourseCateHomeworkRelation();
            relation.setHomeworkId(homeworkId);
            relation.setCourseCateId(courseCategoryId);
            courseCateHomeworkRelations.add(relation);
        }
        return courseCategoryHomeworkDao.insertList(courseCateHomeworkRelations);
    }
}
