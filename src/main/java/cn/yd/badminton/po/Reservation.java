package cn.yd.badminton.po;

import java.util.Date;

public class Reservation {
    private Integer reservationId;

    private Integer areaId;

    private Integer userId;

    private Date preDate;

    private Integer starttime;

    private Integer stoptime;

    private Integer preStatus;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPreDate() {
        return preDate;
    }

    public void setPreDate(Date preDate) {
        this.preDate = preDate;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getStoptime() {
        return stoptime;
    }

    public void setStoptime(Integer stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }
}