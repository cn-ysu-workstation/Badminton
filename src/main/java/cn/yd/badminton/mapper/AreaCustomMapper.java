package cn.yd.badminton.mapper;
import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.Reservation;

import java.util.List;

public interface AreaCustomMapper {

    //显示每个场地的实际运营时间，盈利情况(显示数据时使用)
    List<AreaCustom> selectAreaAndReserVation();
    //显示一个场地的全部信息
    AreaCustom selectAreaAllInfo(Integer id);

    //查询每个场地的预约情况
    List<AreaCustom> selectAreaReservation(Reservation reservation);

    //查询场地信息和对应图片
    List<AreaCustom> selectAreaAndAreaListPic();
}