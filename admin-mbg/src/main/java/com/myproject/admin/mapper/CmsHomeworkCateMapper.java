package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsHomeworkCate;
import com.myproject.admin.model.CmsHomeworkCateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsHomeworkCateMapper {
    long countByExample(CmsHomeworkCateExample example);

    int deleteByExample(CmsHomeworkCateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsHomeworkCate record);

    int insertSelective(CmsHomeworkCate record);

    List<CmsHomeworkCate> selectByExample(CmsHomeworkCateExample example);

    CmsHomeworkCate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsHomeworkCate record, @Param("example") CmsHomeworkCateExample example);

    int updateByExample(@Param("record") CmsHomeworkCate record, @Param("example") CmsHomeworkCateExample example);

    int updateByPrimaryKeySelective(CmsHomeworkCate record);

    int updateByPrimaryKey(CmsHomeworkCate record);
}