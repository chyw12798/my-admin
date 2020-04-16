package com.myproject.admin.service;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.model.CmsCourseCart;

import java.util.List;

public interface CmsCourseCartService {
    CommonResult add(CmsCourseCart cart);

    List<CmsCourseCart> list();
}
