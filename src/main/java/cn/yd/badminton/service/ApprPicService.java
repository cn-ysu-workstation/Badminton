package cn.yd.badminton.service;

import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.Appraisalpic;

public interface ApprPicService {

    void saveApprPic(Appraisalpic apprpic);

    void deleteAppraisalPics(Appraisal appraisal);
}
