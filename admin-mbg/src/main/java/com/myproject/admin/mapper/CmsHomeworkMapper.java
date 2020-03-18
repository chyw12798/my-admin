package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsHomework;
import com.myproject.admin.model.CmsHomeworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsHomeworkMapper {
    long countByExample(CmsHomeworkExample example);

    int deleteByExample(CmsHomeworkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsHomework record);

    int insertSelective(CmsHomework record);

    List<CmsHomework> selectByExampleWithBLOBs(CmsHomeworkExample example);

    List<CmsHomework> selectByExample(CmsHomeworkExample example);

    CmsHomework selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsHomework record, @Param("example") CmsHomeworkExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsHomework record, @Param("example") CmsHomeworkExample example);

    int updateByExample(@Param("record") CmsHomework record, @Param("example") CmsHomeworkExample example);

    int updateByPrimaryKeySelective(CmsHomework record);

    int updateByPrimaryKeyWithBLOBs(CmsHomework record);

    int updateByPrimaryKey(CmsHomework record);
}