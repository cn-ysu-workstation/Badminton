package cn.yd.badminton.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andReservationIdIsNull() {
            addCriterion("reservation_ID is null");
            return (Criteria) this;
        }

        public Criteria andReservationIdIsNotNull() {
            addCriterion("reservation_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReservationIdEqualTo(Integer value) {
            addCriterion("reservation_ID =", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotEqualTo(Integer value) {
            addCriterion("reservation_ID <>", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdGreaterThan(Integer value) {
            addCriterion("reservation_ID >", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reservation_ID >=", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdLessThan(Integer value) {
            addCriterion("reservation_ID <", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdLessThanOrEqualTo(Integer value) {
            addCriterion("reservation_ID <=", value, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdIn(List<Integer> values) {
            addCriterion("reservation_ID in", values, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotIn(List<Integer> values) {
            addCriterion("reservation_ID not in", values, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdBetween(Integer value1, Integer value2) {
            addCriterion("reservation_ID between", value1, value2, "reservationId");
            return (Criteria) this;
        }

        public Criteria andReservationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reservation_ID not between", value1, value2, "reservationId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNull() {
            addCriterion("pre_date is null");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNotNull() {
            addCriterion("pre_date is not null");
            return (Criteria) this;
        }

        public Criteria andPreDateEqualTo(Date value) {
            addCriterionForJDBCDate("pre_date =", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pre_date <>", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pre_date >", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pre_date >=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThan(Date value) {
            addCriterionForJDBCDate("pre_date <", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pre_date <=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateIn(List<Date> values) {
            addCriterionForJDBCDate("pre_date in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pre_date not in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pre_date between", value1, value2, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pre_date not between", value1, value2, "preDate");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Integer value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Integer value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Integer value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Integer value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Integer value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Integer> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Integer> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Integer value1, Integer value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNull() {
            addCriterion("stoptime is null");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNotNull() {
            addCriterion("stoptime is not null");
            return (Criteria) this;
        }

        public Criteria andStoptimeEqualTo(Integer value) {
            addCriterion("stoptime =", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotEqualTo(Integer value) {
            addCriterion("stoptime <>", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThan(Integer value) {
            addCriterion("stoptime >", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stoptime >=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThan(Integer value) {
            addCriterion("stoptime <", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThanOrEqualTo(Integer value) {
            addCriterion("stoptime <=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIn(List<Integer> values) {
            addCriterion("stoptime in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotIn(List<Integer> values) {
            addCriterion("stoptime not in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeBetween(Integer value1, Integer value2) {
            addCriterion("stoptime between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotBetween(Integer value1, Integer value2) {
            addCriterion("stoptime not between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNull() {
            addCriterion("pre_status is null");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNotNull() {
            addCriterion("pre_status is not null");
            return (Criteria) this;
        }

        public Criteria andPreStatusEqualTo(Integer value) {
            addCriterion("pre_status =", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotEqualTo(Integer value) {
            addCriterion("pre_status <>", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThan(Integer value) {
            addCriterion("pre_status >", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_status >=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThan(Integer value) {
            addCriterion("pre_status <", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pre_status <=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusIn(List<Integer> values) {
            addCriterion("pre_status in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotIn(List<Integer> values) {
            addCriterion("pre_status not in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusBetween(Integer value1, Integer value2) {
            addCriterion("pre_status between", value1, value2, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_status not between", value1, value2, "preStatus");
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