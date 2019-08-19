package cn.yd.badminton.mapper;

import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.AreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface AreaCustomMapper {

    //显示每个场地的实际运营时间，盈利情况
    List<AreaCustom> selectAreaAndReserVation();

}