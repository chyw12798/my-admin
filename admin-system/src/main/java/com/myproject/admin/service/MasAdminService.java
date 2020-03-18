package com.myproject.admin.service;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.component.AdminDetails;
import com.myproject.admin.dto.*;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.model.MasPermission;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface MasAdminService {

    /**
     * @author chyw1
     * @Description 用过名字获取AdminDetails(MasAdmin+MasRole+List<MasPermission>)
     * @Date 11:22　2020/3/12
     * @Param [userName]
     * @return com.myproject.admin.component.AdminDetails
     **/
    AdminDetails loadDetailByName(String userName);

    String login(MasAdminParam adminParam);

    CommonResult register(MasAdmin masAdmin);


    List<MasAdmin> list(String userName,Integer pageNum,Integer pageSize);

    CommonResult updatePassword(UpdatePasswordParam updatePasswordParam);

    /**
     * @author chyw1
     * @Description 返回用户权限
     * @Date 16:21　2020/3/6
     * @Param [id]
     * @return java.util.List<com.myproject.admin.model.MasPermission>
     **/
    List<MasPermission> permissionList(@PathVariable("id") Long id);

    CommonResult permissionUpdate(UpdateAdminPermissionParam updateAdminPermissionParam);

    CommonResult veificationCodelogin(VerificationCodeLoginParam verificationCodeLoginParam);

    CommonResult getVerificationCode(String phone);

    @Transactional
    CommonResult roleUpdate(UpdateAdminRoleParam updateAdminRoleParam);

    Map<String, Object> info(Principal principal);
}
