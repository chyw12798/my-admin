package com.myproject.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsOrderFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsOrderFlowExample() {
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

        public Criteria andFlowNumIsNull() {
            addCriterion("flow_num is null");
            return (Criteria) this;
        }

        public Criteria andFlowNumIsNotNull() {
            addCriterion("flow_num is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNumEqualTo(String value) {
            addCriterion("flow_num =", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotEqualTo(String value) {
            addCriterion("flow_num <>", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumGreaterThan(String value) {
            addCriterion("flow_num >", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumGreaterThanOrEqualTo(String value) {
            addCriterion("flow_num >=", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLessThan(String value) {
            addCriterion("flow_num <", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLessThanOrEqualTo(String value) {
            addCriterion("flow_num <=", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLike(String value) {
            addCriterion("flow_num like", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotLike(String value) {
            addCriterion("flow_num not like", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumIn(List<String> values) {
            addCriterion("flow_num in", values, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotIn(List<String> values) {
            addCriterion("flow_num not in", values, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumBetween(String value1, String value2) {
            addCriterion("flow_num between", value1, value2, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotBetween(String value1, String value2) {
            addCriterion("flow_num not between", value1, value2, "flowNum");
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

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(String value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(String value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(String value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(String value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(String value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLike(String value) {
            addCriterion("pay_amount like", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotLike(String value) {
            addCriterion("pay_amount not like", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<String> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<String> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(String value1, String value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(String value1, String value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andBuyCountsIsNull() {
            addCriterion("buy_counts is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountsIsNotNull() {
            addCriterion("buy_counts is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountsEqualTo(Integer value) {
            addCriterion("buy_counts =", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotEqualTo(Integer value) {
            addCriterion("buy_counts <>", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsGreaterThan(Integer value) {
            addCriterion("buy_counts >", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_counts >=", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsLessThan(Integer value) {
            addCriterion("buy_counts <", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsLessThanOrEqualTo(Integer value) {
            addCriterion("buy_counts <=", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsIn(List<Integer> values) {
            addCriterion("buy_counts in", values, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotIn(List<Integer> values) {
            addCriterion("buy_counts not in", values, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsBetween(Integer value1, Integer value2) {
            addCriterion("buy_counts between", value1, value2, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_counts not between", value1, value2, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFlowSnIsNull() {
            addCriterion("flow_sn is null");
            return (Criteria) this;
        }

        public Criteria andFlowSnIsNotNull() {
            addCriterion("flow_sn is not null");
            return (Criteria) this;
        }

        public Criteria andFlowSnEqualTo(String value) {
            addCriterion("flow_sn =", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnNotEqualTo(String value) {
            addCriterion("flow_sn <>", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnGreaterThan(String value) {
            addCriterion("flow_sn >", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnGreaterThanOrEqualTo(String value) {
            addCriterion("flow_sn >=", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnLessThan(String value) {
            addCriterion("flow_sn <", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnLessThanOrEqualTo(String value) {
            addCriterion("flow_sn <=", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnLike(String value) {
            addCriterion("flow_sn like", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnNotLike(String value) {
            addCriterion("flow_sn not like", value, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnIn(List<String> values) {
            addCriterion("flow_sn in", values, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnNotIn(List<String> values) {
            addCriterion("flow_sn not in", values, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnBetween(String value1, String value2) {
            addCriterion("flow_sn between", value1, value2, "flowSn");
            return (Criteria) this;
        }

        public Criteria andFlowSnNotBetween(String value1, String value2) {
            addCriterion("flow_sn not between", value1, value2, "flowSn");
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