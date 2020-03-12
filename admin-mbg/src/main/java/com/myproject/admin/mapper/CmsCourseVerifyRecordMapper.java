package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseVerifyRecord;
import com.myproject.admin.model.CmsCourseVerifyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseVerifyRecordMapper {
    long countByExample(CmsCourseVerifyRecordExample example);

    int deleteByExample(CmsCourseVerifyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseVerifyRecord record);

    int insertSelective(CmsCourseVerifyRecord record);

    List<CmsCourseVerifyRecord> selectByExample(CmsCourseVerifyRecordExample example);

    CmsCourseVerifyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseVerifyRecord record, @Param("example") CmsCourseVerifyRecordExample example);

    int updateByExample(@Param("record") CmsCourseVerifyRecord record, @Param("example") CmsCourseVerifyRecordExample example);

    int updateByPrimaryKeySelective(CmsCourseVerifyRecord record);

    int updateByPrimaryKey(CmsCourseVerifyRecord record);
}