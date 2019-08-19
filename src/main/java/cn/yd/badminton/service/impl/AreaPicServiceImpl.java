package cn.yd.badminton.service.impl;


import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AreapicMapper;
import cn.yd.badminton.po.Areapic;
import cn.yd.badminton.po.AreapicExample;
import cn.yd.badminton.service.AreaPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaPicServiceImpl implements AreaPicService {

    @Autowired
    private AreapicMapper areapicMapper;

    @Override
    public void saveAreaPic(Areapic areapic) throws Exception {
        try{
            areapicMapper.insertSelective(areapic);
        }catch (Exception e){
            throw new CustomException("对不起，添加图片错误！");
        }

    }

    @Override
    public void updateAreaPic(Areapic areapic) throws Exception {
        try{
            areapicMapper.updateByPrimaryKeySelective(areapic);
        }catch (Exception e){
            throw new CustomException("对不起，更新图片错误！");
        }

    }

    @Override
    public List<Areapic> findPrimaryId(Areapic areapic) throws Exception {
        try {
            AreapicExample areapicExample = new AreapicExample();
            AreapicExample.Criteria criteria = areapicExample.createCriteria();
            criteria.andAreaIdEqualTo(areapic.getAreaId());
            return areapicMapper.selectByExample(areapicExample);
        }catch (Exception e){
            throw new CustomException("对不起，找不到相关场地的图片!");
        }

    }
}
