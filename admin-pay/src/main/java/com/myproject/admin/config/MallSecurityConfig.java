package com.myproject.admin.config;

import com.myproject.admin.securityConfig.SecurityConfig;
import com.myproject.admin.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * mall-security模块相关配置
 * Created by macro on 2019/11/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MallSecurityConfig extends SecurityConfig {

    @Autowired
    private UmsUserService umsUserService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> umsUserService.loadUserByUserName(username);
    }
}