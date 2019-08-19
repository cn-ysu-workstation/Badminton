package cn.yd.badminton.service;

<<<<<<< HEAD
import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.PageBean;

public interface AreaService {
    public Area findAreaById(Integer id) throws  Exception;
    public PageBean<Area> findAllAreas(Integer pc, Integer ps, Area area) throws Exception;
    public void deleteAreaById(Integer id) throws  Exception;
    public void saveArea(Area area) throws Exception;
    public void updateArea(Area area) throws  Exception;
=======
import cn.yd.badminton.po.AreaCustom;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AreaService {
    //查询场地对应的营业时间和价格
    List<AreaCustom> selectAreaAndReserVation() throws Exception;
>>>>>>> origin/master
}
