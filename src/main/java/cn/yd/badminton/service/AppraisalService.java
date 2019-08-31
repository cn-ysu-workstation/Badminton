package cn.yd.badminton.service;

import cn.yd.badminton.po.ApprCustom;
import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.AppraisalCustom;

import java.util.List;

import java.util.List;

public interface AppraisalService {

    void InsertIntoAppraisal(Appraisal appraisal) throws  Exception;
    List <AppraisalCustom> findAppraisalByareaid(Integer id) throws  Exception;
    void deleteAppraisal(Appraisal appraisal) throws Exception;
    void updateAppraisal(Appraisal appraisal);
    List<ApprCustom> selectApprs(Integer userId, Integer areaId);
}
