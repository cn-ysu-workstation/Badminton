package cn.yd.badminton.po;

import java.util.List;

public class AppraisalCustom extends Appraisal{
    private Area area;
    private User user;
    private List<Appraisalpic> appraisalpicList;

    public List<Appraisalpic> getAppraisalpicList() {
        return appraisalpicList;
    }

    public void setAppraisalpicList(List<Appraisalpic> appraisalpicList) {
        this.appraisalpicList = appraisalpicList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
