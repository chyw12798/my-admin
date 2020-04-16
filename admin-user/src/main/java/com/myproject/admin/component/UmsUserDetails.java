package com.myproject.admin.component;

import com.myproject.admin.model.UmsUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * @ClassName UserDetail
 * @Description 用户信息类，根据需求封装用户的信息
 * @Author chyw1
 * @Date 2020/3/30 11:06
 * @Version 1.0
 */
public class UmsUserDetails implements UserDetails {

    // 请仔细阅读UserDetails的doc注释

    private UmsUser umsUser;
    // 用户没有权限、角色这一需求。

    public UmsUserDetails(UmsUser umsUser) {
        this.umsUser = umsUser;
    }

    public UmsUser getUmsUser() {
        return this.umsUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.umsUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.umsUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 账户是不是没过期？是的！
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 账户是不是没有冻结？是的！
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 用户是不是可用？
        return this.umsUser.getStatus().equals(1);
    }
}
