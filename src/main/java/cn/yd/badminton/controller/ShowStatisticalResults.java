package cn.yd.badminton.controller;

import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.po.AreaExample;
import cn.yd.badminton.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
*系统统计功能
* @Author 杜艳辉
*系统自动显示每个场地的实际运营时间，盈利情况，为管理员的管理提供科学依据。
*/
@Controller
@RequestMapping("/ShowStatistical")
public class ShowStatisticalResults {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/toStatisticalResults")
    public String toStatisticalResults() throws Exception {
        return "Visualization/statistical";
    }

    @RequestMapping("/toStatisticalResults_changdi")
    public String toStatisticalResults_changdi() throws Exception {
        return "Visualization/statistical_changdi";
    }

    @RequestMapping("/toStatisticalResults_changdi_zongyingli")
    public String toStatisticalResults_changdi_zongyingli() throws Exception {
        return "Visualization/statistical_changdi_zongyingli";
    }

    //日历图
    @RequestMapping("/toStatisticalResults_allTimeBymonth")
    public String toStatisticalResults_allTimeBymonth() throws Exception {
        return "Visualization/statistical_allTimeBymonth";
    }
    @RequestMapping("/StatisticalResultsJSON")
    @ResponseBody
    public List<AreaCustom> StatisticalResults() throws Exception {
        List<AreaCustom> areaCustomList = areaService.selectAreaAndReserVation();

        return areaCustomList;
    }
}
