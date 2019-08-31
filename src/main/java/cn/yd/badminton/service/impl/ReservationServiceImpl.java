package cn.yd.badminton.service.impl;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.ReservationCustomMapper;
import cn.yd.badminton.mapper.ReservationMapper;
import cn.yd.badminton.po.Reservation;
import cn.yd.badminton.po.ReservationCustom;
import cn.yd.badminton.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private ReservationCustomMapper reservationCustomMapper;

    @Override
    public void saveReservation(Reservation reservation) throws Exception {
        try{
            reservationMapper.insertSelective(reservation);
        }catch (Exception e)
        {
            throw new CustomException("对不起，添加预约失败！");
        }
    }

    @Override
    public void deleteReservation(Reservation reservation) throws Exception {
        try {
            reservationMapper.deleteByPrimaryKey(reservation.getReservationId());
        }catch (Exception e){
            throw  new CustomException("对不起，删除预约失败！");
        }
    }

    //更新成代付款状态
    @Override
    public void updateReservation(Reservation reservation) throws Exception {
        try {
            Reservation reservation1 = reservationMapper.selectByPrimaryKey(reservation.getReservationId());
            reservation1.setPreStatus(1);
            reservationMapper.updateByPrimaryKey(reservation1);
        }catch (Exception e){
            throw new CustomException("对不起，更新预约失败");
        }
    }

    @Override
    public List<ReservationCustom> searchReservaionByuserId(Reservation reservation) throws Exception {
        try {
            return reservationCustomMapper.selectReservarionByuserId(reservation.getUserId());
        }catch (Exception e){
            throw new Exception("对不起，查询您的预约信息失败!");
        }
    }

    @Override
    public List<ReservationCustom> searchAllReservation() throws Exception {
        try {
            return reservationCustomMapper.selectAllReservation();
        }catch (Exception e){
            throw new Exception("对不起，查询所有的预约信息失败");
        }

    }
    @Override
    public void updateReservationReject(Reservation reservation) throws Exception {
        try {
            reservation = reservationMapper.selectByPrimaryKey(reservation.getReservationId());
            reservation.setPreStatus(-1);
            reservationMapper.updateByPrimaryKey(reservation);
        }catch (Exception e){
            throw new CustomException("对不起，更新预约失败");
        }
    }


}
