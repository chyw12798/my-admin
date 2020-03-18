package com.myproject.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.admin.component.AdminDetails;
import com.myproject.admin.mapper.CmsHomeworkCateMapper;
import com.myproject.admin.mapper.CmsHomeworkMapper;
import com.myproject.admin.model.CmsHomework;
import com.myproject.admin.model.CmsHomeworkCate;
import com.myproject.admin.model.CmsHomeworkExample;
import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.service.CmsHomeworkService;
import com.myproject.admin.service.MasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CmsHomeworkServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 17:41
 * @Version 1.0
 */
@Service
public class CmsHomeworkServiceImpl implements CmsHomeworkService {

    @Autowired
    private CmsHomeworkMapper homeworkMapper;
    @Autowired
    private MasUserService masUserService;
    @Autowired
    private CmsHomeworkCateMapper homeworkCateMapper;

    @Override
    public int add(CmsHomework cmsHomework) {
        MasAdmin masAdmin = masUserService.getConcurrentAdmin();
        cmsHomework.setCreater(masAdmin.getNickName());
        cmsHomework.setStatus(1);
        return homeworkMapper.insertSelective(cmsHomework);
    }

    @Override
    public List<CmsHomework> list(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return homeworkMapper.selectByExampleWithBLOBs(new CmsHomeworkExample());
    }

    @Override
    public int addCategory(CmsHomeworkCate homeworkCate) {
        homeworkCate.setStatus(1);
        return homeworkCateMapper.insert(homeworkCate);
    }

    @Override
    public int update(CmsHomework homework) {
        CmsHomeworkExample homeworkExample = new CmsHomeworkExample();
        homeworkExample.createCriteria().andIdEqualTo(homework.getId());
        return homeworkMapper.updateByExampleSelective(homework,homeworkExample);
    }
}
