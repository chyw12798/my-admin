package com.myproject.admin.service;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.component.UmsUserDetails;
import com.myproject.admin.dto.UmsUserLoginParam;
import com.myproject.admin.dto.UpdatePasswordParam;
import com.myproject.admin.model.UmsUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsUserService {

    // 获取当前用户
    UmsUser getCurrentMember();

    /**
     * @Description 通过名字获取用户(需进行NPE判断)
     * @Param [userName]
     * @return java.util.List<com.myproject.admin.model.UmsUser>
     **/
    List<UmsUser> getUserByName(String userName);

    /**
     * @author chyw1
     * @Description 通过账号得到用户信息UmsUserDetails
     * @Date 16:11　2020/3/30
     * @Param [userName] 用户账号
     * @return com.myproject.admin.component.UmsUserDetails
     * @exception UsernameNotFoundException
     **/
    UmsUserDetails loadUserByUserName(String userName);

    // 用户登录
    String login(UmsUserLoginParam userLoginParam);

    // 注册
    @Transactional
    CommonResult register(UmsUser umsUser);

    CommonResult updatePassword(UpdatePasswordParam updatePasswordParam);
}
