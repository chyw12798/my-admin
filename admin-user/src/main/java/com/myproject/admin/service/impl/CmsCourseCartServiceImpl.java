package com.myproject.admin.service.impl;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.mapper.CmsCourseCartMapper;
import com.myproject.admin.model.CmsCourseCart;
import com.myproject.admin.model.CmsCourseCartExample;
import com.myproject.admin.model.UmsUser;
import com.myproject.admin.service.CmsCourseCartService;
import com.myproject.admin.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CmsCourseCartServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 19:47
 * @Version 1.0
 */
@Service
public class CmsCourseCartServiceImpl implements CmsCourseCartService {
    @Autowired
    private CmsCourseCartMapper cmsCourseCartMapper;

    @Autowired
    private UmsUserService umsUserService;

    @Override
    public CommonResult add(CmsCourseCart cart) {

        UmsUser umsUser = umsUserService.getCurrentMember();

        CmsCourseCartExample courseCartExample = new CmsCourseCartExample();
        courseCartExample.createCriteria().andCourseIdEqualTo(cart.getCourseId())
                .andUserIdEqualTo(umsUser.getId())
                .andDeleteStatusEqualTo(0);
        List<CmsCourseCart> cartList = cmsCourseCartMapper.selectByExample(courseCartExample);
        if (!CollectionUtils.isEmpty(cartList)){
            return CommonResult.failed("已在购物车了,快去下单吧~");
        }

        cart.setUserName(umsUser.getNickName());
        cart.setUserId(umsUser.getId());
        cart.setDeleteStatus(0);
        cart.setCreateTime(new Date());
        int count = cmsCourseCartMapper.insert(cart);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("加入购物车失败...");
    }

    @Override
    public List<CmsCourseCart> list() {
        UmsUser umsUser = umsUserService.getCurrentMember();
        CmsCourseCartExample courseCartExample = new CmsCourseCartExample();
        courseCartExample.createCriteria().andDeleteStatusEqualTo(0)
                .andUserIdEqualTo(umsUser.getId());
        List<CmsCourseCart> courseCartList = cmsCourseCartMapper.selectByExample(courseCartExample);

        return courseCartList;
    }
}
