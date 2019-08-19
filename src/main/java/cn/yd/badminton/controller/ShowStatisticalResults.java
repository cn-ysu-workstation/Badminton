package cn.yd.badminton.controller;

import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.AreaExample;
import cn.yd.badminton.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
*系统统计功能
*系统自动显示每个场地的实际运营时间，盈利情况，为管理员的管理提供科学依据。
*/
@RestController
@RequestMapping("/ShowStatistical")
public class ShowStatisticalResults {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/StatisticalResults")
    public List<AreaCustom> StatisticalResults() throws Exception {
        List<AreaCustom> areaCustomList = areaService.selectAreaAndReserVation();
        return areaCustomList;
    }
}
