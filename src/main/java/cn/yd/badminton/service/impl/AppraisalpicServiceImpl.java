package cn.yd.badminton.service.impl;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AppraisalpicMapper;
import cn.yd.badminton.po.Appraisalpic;
import cn.yd.badminton.po.AppraisalpicExample;
import cn.yd.badminton.po.UserExample;
import cn.yd.badminton.service.AppraisalpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppraisalpicServiceImpl implements AppraisalpicService {

    @Autowired
    private AppraisalpicMapper appraisalpicMapper;

    @Override
    public void saveAppraisalPic(Appraisalpic appraisalpic) throws Exception {
        try {
            appraisalpicMapper.insertSelective(appraisalpic);
        }catch (Exception e)
        {
            throw new CustomException("对不起，添加评论图片失败!");
        }
    }
}
