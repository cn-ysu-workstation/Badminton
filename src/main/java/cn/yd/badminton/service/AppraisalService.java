package cn.yd.badminton.service;

import cn.yd.badminton.po.Appraisal;

public interface AppraisalService {

    void  InsertIntoAppraisal(Appraisal appraisal) throws  Exception;

    void deleteAppraisal(Appraisal appraisal);
}
