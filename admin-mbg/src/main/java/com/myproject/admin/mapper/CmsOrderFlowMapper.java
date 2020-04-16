package com.myproject.admin.mapper;

import com.myproject.admin.model.CmsOrderFlow;
import com.myproject.admin.model.CmsOrderFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsOrderFlowMapper {
    long countByExample(CmsOrderFlowExample example);

    int deleteByExample(CmsOrderFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsOrderFlow record);

    int insertSelective(CmsOrderFlow record);

    List<CmsOrderFlow> selectByExample(CmsOrderFlowExample example);

    CmsOrderFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsOrderFlow record, @Param("example") CmsOrderFlowExample example);

    int updateByExample(@Param("record") CmsOrderFlow record, @Param("example") CmsOrderFlowExample example);

    int updateByPrimaryKeySelective(CmsOrderFlow record);

    int updateByPrimaryKey(CmsOrderFlow record);
}