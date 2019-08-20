package cn.yd.badminton.service.impl;

import cn.yd.badminton.mapper.AppraisalMapper;
import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppraisalServiceImpl  implements AppraisalService {

    @Autowired
    private AppraisalMapper appraisalMapper;


    @Override
    public void InsertIntoAppraisal(Appraisal appraisal) throws Exception {

        appraisalMapper.insertSelective(appraisal);


    }

    @Override
    public void deleteAppraisal(Appraisal appraisal) {
        appraisalMapper.deleteByPrimaryKey(appraisal.getAppraisalId());
    }
}
