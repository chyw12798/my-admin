package com.myproject.admin.dto;

import com.myproject.admin.model.CmsCourseCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName CmsCourseCategoryNode
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/17 9:32
 * @Version 1.0
 */
@Getter
@Setter
public class CmsCourseCategoryNode extends CmsCourseCategory {
    private List<CmsCourseCategoryNode> children;
}
