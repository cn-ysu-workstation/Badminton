package cn.yd.badminton.po;

import java.util.List;

public class AreaQueryVo {

    private AreaCustom areaCustom;
    private List<Area> areaList;

    public AreaCustom getAreaCustom() {
        return areaCustom;
    }

    public void setAreaCustom(AreaCustom areaCustom) {
        this.areaCustom = areaCustom;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
