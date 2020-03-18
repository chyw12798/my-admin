package com.myproject.admin.service.impl;

import com.myproject.admin.mapper.CmsCourseItemMapper;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseItem;
import com.myproject.admin.model.CmsCourseItemExample;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.service.CmsCourseItemService;
import com.myproject.admin.service.MasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CmsCourseItemServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/18 10:51
 * @Version 1.0
 */
@Service
public class CmsCourseItemServiceImpl implements CmsCourseItemService {

    @Autowired
    private CmsCourseItemMapper courseItemMapper;
    @Autowired
    private MasUserService userService;

    @Override
    public List<CmsCourseItem> listAll(Long courseId) {

        CmsCourseItemExample cmsCourseItemExample = new CmsCourseItemExample();
        cmsCourseItemExample.createCriteria().andCourseIdEqualTo(courseId);
        List<CmsCourseItem> list = courseItemMapper.selectByExample(cmsCourseItemExample);
        return list;
    }

    @Override
    public int add(CmsCourseItem cmsCourseItem) {
        cmsCourseItem.setFinishStatus(0);
        MasAdmin masAdmin = userService.getConcurrentAdmin();
        cmsCourseItem.setTeacherId(masAdmin.getId());
        return courseItemMapper.insertSelective(cmsCourseItem);
    }
}
