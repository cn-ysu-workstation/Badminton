package cn.yd.badminton.po;

import java.util.ArrayList;
import java.util.List;

public class ApprCustom {
    private Appraisal appraisal;
    private List<Appraisalpic> appraisalpicList;

    public ApprCustom() {
        this.appraisal = new Appraisal();
        this.appraisalpicList = new ArrayList<Appraisalpic>();
    }

    public ApprCustom(Appraisal appraisal, List<Appraisalpic> appraisalpicList) {
        this.appraisal = appraisal;
        this.appraisalpicList = appraisalpicList;
    }

    public Appraisal getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(Appraisal appraisal) {
        this.appraisal = appraisal;
    }

    public List<Appraisalpic> getAppraisalpicList() {
        return appraisalpicList;
    }

    public void setAppraisalpicList(List<Appraisalpic> appraisalpicList) {
        this.appraisalpicList = appraisalpicList;
    }
}
