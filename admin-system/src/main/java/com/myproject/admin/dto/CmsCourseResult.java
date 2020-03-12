package com.myproject.admin.dto;

import com.myproject.admin.model.CmsCourse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName MasCourseResult
 * @Description 编辑课程需要返回的课程信息
 * @Author chyw1
 * @Date 2020/3/7 12:08
 * @Version 1.0
 */
public class CmsCourseResult  extends CmsCourse {
    // CmsCourse课程表是一个中间表，
    // 对于后面需要增加的需求，如优惠券，积分等都需要相应的关联查询
    // 就目前而言，所有优惠要等后台前后端实现后，再进行扩展


    // cms_course
}
