package cn.yd.badminton.po;

import java.util.List;

public class AreaCustom extends Area {

    private List<Areapic> areapicList;
    private Reservation reservation;
    private List<ReservationCustom> reservationCustomList;
    private Integer time_status[] = new Integer[13];

    public List<ReservationCustom> getReservationCustomList() {
        return reservationCustomList;
    }

    public void setReservationCustomList(List<ReservationCustom> reservationCustomList) {
        this.reservationCustomList = reservationCustomList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    private List<Reservation> reservationList;


    public List<Areapic> getAreapicList() {
        return areapicList;
    }

    public void setAreapicList(List<Areapic> areapicList) {
        this.areapicList = areapicList;
    }



    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }





    public Integer[] getTime_status() {
        return time_status;
    }

    public void setTime_status(Integer[] time_status) {
        this.time_status = time_status;
    }
}
