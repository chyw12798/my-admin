package com.myproject.admin.securityConfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@EnableTransactionManagement
@MapperScan({"com.myproject.admin.dao","com.myproject.admin.mapper"})
public class MybatisConfig {
}
