package cn.yd.badminton.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Appraisal {
    private Integer appraisalId;

    private Integer userId;

    private Integer areaId;

    private Integer appStatus;
    //解决取出的时间比实际时间少8小时的问题
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date appTime;

    private String info;

    public Integer getAppraisalId() {
        return appraisalId;
    }

    public void setAppraisalId(Integer appraisalId) {
        this.appraisalId = appraisalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

}