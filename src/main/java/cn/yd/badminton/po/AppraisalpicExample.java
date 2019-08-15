package cn.yd.badminton.po;

import java.util.ArrayList;
import java.util.List;

public class AppraisalpicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppraisalpicExample() {
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

        public Criteria andApppicIdIsNull() {
            addCriterion("apppic_ID is null");
            return (Criteria) this;
        }

        public Criteria andApppicIdIsNotNull() {
            addCriterion("apppic_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApppicIdEqualTo(Integer value) {
            addCriterion("apppic_ID =", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdNotEqualTo(Integer value) {
            addCriterion("apppic_ID <>", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdGreaterThan(Integer value) {
            addCriterion("apppic_ID >", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apppic_ID >=", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdLessThan(Integer value) {
            addCriterion("apppic_ID <", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdLessThanOrEqualTo(Integer value) {
            addCriterion("apppic_ID <=", value, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdIn(List<Integer> values) {
            addCriterion("apppic_ID in", values, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdNotIn(List<Integer> values) {
            addCriterion("apppic_ID not in", values, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdBetween(Integer value1, Integer value2) {
            addCriterion("apppic_ID between", value1, value2, "apppicId");
            return (Criteria) this;
        }

        public Criteria andApppicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apppic_ID not between", value1, value2, "apppicId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdIsNull() {
            addCriterion("appraisal_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdIsNotNull() {
            addCriterion("appraisal_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdEqualTo(Integer value) {
            addCriterion("appraisal_ID =", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdNotEqualTo(Integer value) {
            addCriterion("appraisal_ID <>", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdGreaterThan(Integer value) {
            addCriterion("appraisal_ID >", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraisal_ID >=", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdLessThan(Integer value) {
            addCriterion("appraisal_ID <", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdLessThanOrEqualTo(Integer value) {
            addCriterion("appraisal_ID <=", value, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdIn(List<Integer> values) {
            addCriterion("appraisal_ID in", values, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdNotIn(List<Integer> values) {
            addCriterion("appraisal_ID not in", values, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdBetween(Integer value1, Integer value2) {
            addCriterion("appraisal_ID between", value1, value2, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andAppraisalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appraisal_ID not between", value1, value2, "appraisalId");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
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