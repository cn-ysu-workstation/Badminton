package cn.yd.badminton.service.impl;


import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AppraisalCustomMapper;
import cn.yd.badminton.mapper.AppraisalMapper;
import cn.yd.badminton.mapper.AppraisalpicMapper;
import cn.yd.badminton.po.*;
import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.AppraisalCustom;
import cn.yd.badminton.service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Service
@Transactional
public class AppraisalServiceImpl  implements AppraisalService {

    @Autowired
    private AppraisalMapper appraisalMapper;
    @Autowired
    private AppraisalCustomMapper appraisalCustomMapper;

    @Autowired
    private AppraisalpicMapper appraisalpicMapper;

    @Override
    public void InsertIntoAppraisal(Appraisal appraisal) throws Exception {
        try{
            appraisalMapper.insertSelective(appraisal);
        }catch (Exception e){
            throw new CustomException("对不起，添加评论失败!");
        }
    }

    @Override
    public List<AppraisalCustom> findAppraisalByareaid(Integer id) throws Exception {
        try {
            return appraisalCustomMapper.selectAppraisalByareaid(id);
        }catch (Exception e)
        {
            throw new Exception("对不起，查询评论失败!");
        }
    }

    @Override
    public void deleteAppraisal(Appraisal appraisal) throws Exception {
        try{
            appraisalMapper.deleteByPrimaryKey(appraisal.getAppraisalId());
        }catch (Exception e)
        {
            throw new Exception("对不起，删除评论失败！");
        }

    }


    @Override
    public void updateAppraisal(Appraisal appraisal) {
        appraisalMapper.updateByPrimaryKeySelective(appraisal);
    }

    @Override
    public List<ApprCustom> selectApprs(Integer userId, Integer areaId) {
//        Appraisal appraisal = new Appraisal();
//        appraisal.setUserId(userId);
//        appraisal.setAreaId(areaId);
        AppraisalExample appraisalExample= new AppraisalExample();
        AppraisalExample.Criteria criteria = appraisalExample.createCriteria();
        if(userId!=null){
            criteria.andUserIdEqualTo(userId);
        }
        if(areaId!=null){
            criteria.andAreaIdEqualTo(areaId);
        }
        //先根据用户id和场地id找相应的文字评论(列表)
        List<Appraisal> appraisalList= appraisalMapper.selectByExampleWithBLOBs(appraisalExample);

        List<ApprCustom>apprCustomList= new ArrayList<ApprCustom>();
        for(Appraisal appr :appraisalList){
            AppraisalpicExample appraisalpicExample = new AppraisalpicExample();
            AppraisalpicExample.Criteria criteria1=appraisalpicExample.createCriteria();
            criteria1.andAppraisalIdEqualTo(appr.getAppraisalId());
            //根据每一个文字评论对应的id找到对应的图片
            List<Appraisalpic> appraisalpicList=appraisalpicMapper.selectByExample(appraisalpicExample);
            //转换成对应的文字+图片评论(列表)
            apprCustomList.add(new ApprCustom(appr,appraisalpicList));
        }
        return apprCustomList;
    }
}
