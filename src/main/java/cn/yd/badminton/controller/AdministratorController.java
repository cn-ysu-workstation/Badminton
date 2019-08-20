package cn.yd.badminton.controller;

import cn.yd.badminton.po.*;
import cn.yd.badminton.service.AdministratorService;
import cn.yd.badminton.service.AreaPicService;
import cn.yd.badminton.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private AreaPicService areaPicService;

    @RequestMapping("/toLogin")
    private String toLogin(){
        return "Login/login";
    }
    @RequestMapping("/Login")
    private String Login(Model model, HttpSession session, Administrator administrator){
        try {
            Administrator administratorRes = administratorService.findAdministartorByLogin(administrator);
            session.setAttribute("Administrator",administratorRes);
        }catch (Exception e){
            model.addAttribute("mess",e.getMessage());
            return "Login/login";
        }
        return "index1";
    }
    @RequestMapping("/findAllAreas")
    private String findAllAreas(Model model, Area area, @RequestParam(value = "pc",required = true,defaultValue = "1") Integer pc)
    {
        // 定义每页显示的商品数量
        Integer ps = 4;

        try {
            // 查询数据表所有商品信息
            PageBean<Area> pageBean = areaService.findAllAreas(pc,ps,area);
            model.addAttribute("pageBean", pageBean);

        } catch (Exception e) {
            new RuntimeException();
        }
        return "area/areasList";
    }
    @RequestMapping("/toUpdateArea")
    private String toUpdateAreas(Model model,@RequestParam(value = "area_id",required = true) Integer[] id) throws Exception {

        List<Area> areaList = new ArrayList<Area>();
        for (Integer areaid: id) {
            Area area = areaService.findAreaById(areaid);
            areaList.add(area);
        }
        model.addAttribute("areaList",areaList);
        return "area/editArea";
    }
    @RequestMapping("/updateArea")
    private String updateArea(MultipartFile file, AreaQueryVo areaQueryVo) throws Exception {
        List<Area> areaList = areaQueryVo.getAreaList();
        for (Area area:areaList) {
            areaService.updateArea(area);
            if(!file.isEmpty())
            {
                Areapic areapic = new Areapic();
                areapic.setAreaId(area.getAreaId());
                List<Areapic> areapicList = areaPicService.findPrimaryId(areapic);
                for (Areapic areaph:areapicList) {
                    FastDFSClient client = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
                    String str = client.uploadFile(file.getBytes(),"jpg");
                    areaph.setPic(str);
                    areaPicService.updateAreaPic(areaph);
                }
            }
        }
        return "area/areasList";
    }
    @RequestMapping("/toAddArea")
    private String toAddArea(){
        return "area/addArea";
    }
    @RequestMapping("/addArea")
    private String saveArea(MultipartFile file,Area area) throws Exception {
        area.setGoodNum(0);
        area.setBadNum(0);
        area.setGoodRate(0);
        area.setProfit(BigDecimal.valueOf(0.0));
        areaService.saveArea(area);
        if(!file.isEmpty())
        {
            Areapic areapic = new Areapic();
            areapic.setAreaId(area.getAreaId());
            FastDFSClient client = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
            String str = client.uploadFile(file.getBytes(),"jpg");
            areapic.setPic(str);
            areaPicService.saveAreaPic(areapic);
        }
        return "area/areaList";
    }
    @RequestMapping("/deleteArea")
    private String deleteArea(@RequestParam(value = "area_id",required = true)Integer[] id) throws Exception {
        for (Integer areaid:id) {
            areaService.deleteAreaById(areaid);
        }
        return  "area/areaList";
    }
}
