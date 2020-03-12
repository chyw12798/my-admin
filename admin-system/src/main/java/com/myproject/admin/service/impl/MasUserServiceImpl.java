package com.myproject.admin.service.impl;

import com.myproject.admin.component.AdminDetails;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.service.MasUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @ClassName MasUserServiceImpl
 * @Description 获取当前用户登录
 * @Author chyw1
 * @Date 2020/3/7 17:38
 * @Version 1.0
 */
@Service
public class MasUserServiceImpl implements MasUserService {

    /**
     * @author chyw1
     * @Description 获取当前登录用户
     * @Date 17:39　2020/3/7
     * @Param []
     * @return com.myproject.admin.model.MasAdmin
     **/
    @Override
    public MasAdmin getConcurrentAdmin() {

        AdminDetails adminDetails = getAdminDetails();
        return adminDetails.getMasAdmin();
    }

    private AdminDetails getAdminDetails() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        AdminDetails adminDetails = (AdminDetails)auth.getPrincipal();
        return adminDetails;
    }
}
