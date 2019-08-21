package cn.yd.badminton.service;

import cn.yd.badminton.po.ApprCustom;
import cn.yd.badminton.po.Appraisal;

import java.util.List;

public interface AppraisalService {

    void  InsertIntoAppraisal(Appraisal appraisal) throws  Exception;

    void deleteAppraisal(Appraisal appraisal);

    void updateAppraisal(Appraisal appraisal);

    List<ApprCustom> selectApprs(Integer userId, Integer areaId);
}
