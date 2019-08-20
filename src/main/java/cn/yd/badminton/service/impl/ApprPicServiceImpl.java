package cn.yd.badminton.service.impl;

import cn.yd.badminton.mapper.AppraisalMapper;
import cn.yd.badminton.mapper.AppraisalpicMapper;
import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.Appraisalpic;
import cn.yd.badminton.po.AppraisalpicExample;

import cn.yd.badminton.service.ApprPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ApprPicServiceImpl implements ApprPicService {
    @Autowired
    AppraisalpicMapper appraisalpicMapper;

    @Override
    public void saveApprPic(Appraisalpic apprpic) {
        appraisalpicMapper.insertSelective(apprpic);
    }

    @Override
    public void deleteAppraisalPics(Appraisal appraisal) {
        AppraisalpicExample appraisalpicExample = new AppraisalpicExample();
        AppraisalpicExample.Criteria criteria = appraisalpicExample.createCriteria();
        criteria.andAppraisalIdEqualTo(appraisal.getAppraisalId());
        appraisalpicMapper.deleteByExample(appraisalpicExample);
    }
}
