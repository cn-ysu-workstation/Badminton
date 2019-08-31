package cn.yd.badminton.mapper;

import cn.yd.badminton.po.ReservationCustom;

import java.util.List;

public interface ReservationCustomMapper {
    List<ReservationCustom> selectReservarionByuserId(Integer id);
    List<ReservationCustom> selectAllReservation();
}
