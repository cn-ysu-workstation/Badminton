package cn.yd.badminton.service;

import cn.yd.badminton.po.Reservation;
import cn.yd.badminton.po.ReservationCustom;

import java.util.List;

public interface ReservationService {
    void saveReservation(Reservation reservation) throws Exception;
    void deleteReservation(Reservation reservation) throws Exception;
    void updateReservation(Reservation reservation) throws Exception;
    List<ReservationCustom> searchReservaionByuserId(Reservation reservation) throws Exception;
    List<ReservationCustom> searchAllReservation() throws Exception;
    void updateReservationReject(Reservation reservation) throws Exception;
}
