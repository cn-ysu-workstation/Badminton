package cn.yd.badminton.po;

public class Areapic {
    private Integer areapicId;

    private Integer areaId;

    private String pic;

    public Integer getAreapicId() {
        return areapicId;
    }

    public void setAreapicId(Integer areapicId) {
        this.areapicId = areapicId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}