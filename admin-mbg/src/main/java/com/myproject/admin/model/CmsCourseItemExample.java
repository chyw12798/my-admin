package com.myproject.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsCourseItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsCourseItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andFinishStatusIsNull() {
            addCriterion("finish_status is null");
            return (Criteria) this;
        }

        public Criteria andFinishStatusIsNotNull() {
            addCriterion("finish_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinishStatusEqualTo(Integer value) {
            addCriterion("finish_status =", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusNotEqualTo(Integer value) {
            addCriterion("finish_status <>", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusGreaterThan(Integer value) {
            addCriterion("finish_status >", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("finish_status >=", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusLessThan(Integer value) {
            addCriterion("finish_status <", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusLessThanOrEqualTo(Integer value) {
            addCriterion("finish_status <=", value, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusIn(List<Integer> values) {
            addCriterion("finish_status in", values, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusNotIn(List<Integer> values) {
            addCriterion("finish_status not in", values, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusBetween(Integer value1, Integer value2) {
            addCriterion("finish_status between", value1, value2, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andFinishStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("finish_status not between", value1, value2, "finishStatus");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlIsNull() {
            addCriterion("recode_url is null");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlIsNotNull() {
            addCriterion("recode_url is not null");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlEqualTo(String value) {
            addCriterion("recode_url =", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlNotEqualTo(String value) {
            addCriterion("recode_url <>", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlGreaterThan(String value) {
            addCriterion("recode_url >", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("recode_url >=", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlLessThan(String value) {
            addCriterion("recode_url <", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlLessThanOrEqualTo(String value) {
            addCriterion("recode_url <=", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlLike(String value) {
            addCriterion("recode_url like", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlNotLike(String value) {
            addCriterion("recode_url not like", value, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlIn(List<String> values) {
            addCriterion("recode_url in", values, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlNotIn(List<String> values) {
            addCriterion("recode_url not in", values, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlBetween(String value1, String value2) {
            addCriterion("recode_url between", value1, value2, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeUrlNotBetween(String value1, String value2) {
            addCriterion("recode_url not between", value1, value2, "recodeUrl");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteIsNull() {
            addCriterion("recode_minute is null");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteIsNotNull() {
            addCriterion("recode_minute is not null");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteEqualTo(Integer value) {
            addCriterion("recode_minute =", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteNotEqualTo(Integer value) {
            addCriterion("recode_minute <>", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteGreaterThan(Integer value) {
            addCriterion("recode_minute >", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("recode_minute >=", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteLessThan(Integer value) {
            addCriterion("recode_minute <", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("recode_minute <=", value, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteIn(List<Integer> values) {
            addCriterion("recode_minute in", values, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteNotIn(List<Integer> values) {
            addCriterion("recode_minute not in", values, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteBetween(Integer value1, Integer value2) {
            addCriterion("recode_minute between", value1, value2, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andRecodeMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("recode_minute not between", value1, value2, "recodeMinute");
            return (Criteria) this;
        }

        public Criteria andItemSnIsNull() {
            addCriterion("item_sn is null");
            return (Criteria) this;
        }

        public Criteria andItemSnIsNotNull() {
            addCriterion("item_sn is not null");
            return (Criteria) this;
        }

        public Criteria andItemSnEqualTo(String value) {
            addCriterion("item_sn =", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnNotEqualTo(String value) {
            addCriterion("item_sn <>", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnGreaterThan(String value) {
            addCriterion("item_sn >", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnGreaterThanOrEqualTo(String value) {
            addCriterion("item_sn >=", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnLessThan(String value) {
            addCriterion("item_sn <", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnLessThanOrEqualTo(String value) {
            addCriterion("item_sn <=", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnLike(String value) {
            addCriterion("item_sn like", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnNotLike(String value) {
            addCriterion("item_sn not like", value, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnIn(List<String> values) {
            addCriterion("item_sn in", values, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnNotIn(List<String> values) {
            addCriterion("item_sn not in", values, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnBetween(String value1, String value2) {
            addCriterion("item_sn between", value1, value2, "itemSn");
            return (Criteria) this;
        }

        public Criteria andItemSnNotBetween(String value1, String value2) {
            addCriterion("item_sn not between", value1, value2, "itemSn");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeIsNull() {
            addCriterion("recode_time is null");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeIsNotNull() {
            addCriterion("recode_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeEqualTo(Date value) {
            addCriterion("recode_time =", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeNotEqualTo(Date value) {
            addCriterion("recode_time <>", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeGreaterThan(Date value) {
            addCriterion("recode_time >", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recode_time >=", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeLessThan(Date value) {
            addCriterion("recode_time <", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeLessThanOrEqualTo(Date value) {
            addCriterion("recode_time <=", value, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeIn(List<Date> values) {
            addCriterion("recode_time in", values, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeNotIn(List<Date> values) {
            addCriterion("recode_time not in", values, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeBetween(Date value1, Date value2) {
            addCriterion("recode_time between", value1, value2, "recodeTime");
            return (Criteria) this;
        }

        public Criteria andRecodeTimeNotBetween(Date value1, Date value2) {
            addCriterion("recode_time not between", value1, value2, "recodeTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}