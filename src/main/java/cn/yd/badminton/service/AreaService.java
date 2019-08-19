package cn.yd.badminton.service;


import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.PageBean;

import java.util.List;

public interface AreaService {
    public Area findAreaById(Integer id) throws  Exception;
    public PageBean<Area> findAllAreas(Integer pc, Integer ps, Area area) throws Exception;
    public void deleteAreaById(Integer id) throws  Exception;
    public void saveArea(Area area) throws Exception;
    public void updateArea(Area area) throws  Exception;
    public List<AreaCustom> selectAreaAndReserVation() throws Exception;
}
