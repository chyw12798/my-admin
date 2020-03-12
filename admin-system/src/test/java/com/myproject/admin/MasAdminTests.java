package com.myproject.admin;

import com.myproject.admin.dto.CmsCourseResult;
import com.myproject.admin.dto.MasAdminParam;
import com.myproject.admin.service.MasAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasAdminTests {

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    @Autowired
    private MasAdminService adminService;

    @Autowired
    private MasAdminParam adminParam;

    @Autowired
    private CmsCourseResult cmsCourseResult;

    @Test
//    @Transactional   这两个注释就让所有事务操作回滚！(无论成功与否)
//    @Rollback
    public void testInsertBatch(){



//        adminService.register("chyw","123456");

    }
}
