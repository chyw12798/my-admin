package com.myproject.admin.service.impl;

import com.myproject.admin.mapper.CmsCourseMapper;
import com.myproject.admin.mapper.CmsCourseOrderMapper;
import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.CmsCourseOrder;
import com.myproject.admin.model.UmsUser;
import com.myproject.admin.service.CmsCourseOrderService;
import com.myproject.admin.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName CmsCourseOrderServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/31 9:11
 * @Version 1.0
 */
@Service
public class CmsCourseOrderServiceImpl implements CmsCourseOrderService {

    @Autowired
    private UmsUserService umsUserService;

    @Autowired
    private CmsCourseOrderMapper courseOrderMapper;

    @Autowired
    private CmsCourseMapper courseMapper;

    @Override
    public int add(Long cmsCourseId) {

        // 创建订单,进入订单课程预览界面(课程内容+优惠内容+个人信息)
        CmsCourse cmsCourse = courseMapper.selectByPrimaryKey(cmsCourseId);
        if (cmsCourse == null) {
            return 0;
        }
        UmsUser umsUser = umsUserService.getCurrentMember();

        CmsCourseOrder order = new CmsCourseOrder();
        order.setUserId(umsUser.getId());
        order.setTotalAmount(cmsCourse.getPrice());
        order.setStatus(1);
//        order.setPayType(2);
//        order.setPayTime();
        order.setDeleteStatus(0);
        order.setCreateTime(new Date());
        order.setCourseId(cmsCourse.getId());
        order.setConponAmount(new BigDecimal(0));
        order.setPayAmount(order.getTotalAmount().subtract(order.getConponAmount()));
        order.setStatus(1);
        order.setCourseName(cmsCourse.getCourseName());
        return courseOrderMapper.insert(order);
    }

    @Override
    public void showCourse(Long courseId) {

    }
}
