package cn.yd.badminton.service;


import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.PageBean;
import cn.yd.badminton.po.Reservation;

import java.util.List;

public interface AreaService {
    public Area findAreaById(Integer id) throws  Exception;
    public PageBean<AreaCustom> findAllAreas(Integer pc, Integer ps, AreaCustom areaCustom) throws Exception;
    public void deleteAreaById(Integer id) throws  Exception;
    public void saveArea(Area area) throws Exception;
    public void updateArea(Area area) throws  Exception;
    public void updateAreaComment(Area area) throws  Exception;
    public List<AreaCustom> selectAreaAndReserVation() throws Exception;
    public AreaCustom findAreaDetail(Area area) throws  Exception;

    public List<Area> findAllAreas1() throws Exception;

    public List<AreaCustom> selectAreaReservation(Reservation reservation) throws Exception;
}
