package cn.yd.badminton.po;

public class Appraisalpic {
    private Integer apppicId;

    private Integer appraisalId;

    private String pic;

    public Integer getApppicId() {
        return apppicId;
    }

    public void setApppicId(Integer apppicId) {
        this.apppicId = apppicId;
    }

    public Integer getAppraisalId() {
        return appraisalId;
    }

    public void setAppraisalId(Integer appraisalId) {
        this.appraisalId = appraisalId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}