package cn.yd.badminton.service;

import cn.yd.badminton.po.AreaCustom;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AreaService {
    //查询场地对应的营业时间和价格
    List<AreaCustom> selectAreaAndReserVation() throws Exception;
}
