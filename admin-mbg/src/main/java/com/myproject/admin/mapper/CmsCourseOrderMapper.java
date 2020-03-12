package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsCourseOrder;
import com.myproject.admin.model.CmsCourseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCourseOrderMapper {
    long countByExample(CmsCourseOrderExample example);

    int deleteByExample(CmsCourseOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCourseOrder record);

    int insertSelective(CmsCourseOrder record);

    List<CmsCourseOrder> selectByExample(CmsCourseOrderExample example);

    CmsCourseOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCourseOrder record, @Param("example") CmsCourseOrderExample example);

    int updateByExample(@Param("record") CmsCourseOrder record, @Param("example") CmsCourseOrderExample example);

    int updateByPrimaryKeySelective(CmsCourseOrder record);

    int updateByPrimaryKey(CmsCourseOrder record);
}