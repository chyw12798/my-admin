package com.myproject.admin.dto;

import com.myproject.admin.model.CmsCourse;
import com.myproject.admin.model.UmsUser;

import java.math.BigDecimal;

/**
 * @ClassName ShowOrderCourseResult
 * @Description 创建订单前，课程信息展示(课程信息+优惠信息+个人信息)
 * @Author chyw1
 * @Date 2020/3/31 9:16
 * @Version 1.0
 */
public class ShowOrderCourseResult extends CmsCourse {

    private UmsUser umsUser;

    // 可使用积分
    private Integer integaral;

    // 满减活动
//    private

    // 优惠券
//    private

    // 总减免金额
    private BigDecimal reduceAmount;

    // 最后提交金额
    private BigDecimal lastAmount;
}
