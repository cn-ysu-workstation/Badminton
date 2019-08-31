package cn.yd.badminton.service.impl;


import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.*;
import cn.yd.badminton.service.AreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.yd.badminton.mapper.AreaCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private AreaCustomMapper areaCustomMapper;

    @Override
    public Area findAreaById(Integer id) throws Exception {
        try {
            return areaMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            throw new CustomException("对不起，没有查询到此场地！");
        }
    }

    @Override
    public PageBean<AreaCustom> findAllAreas(Integer pc, Integer ps, AreaCustom areaCustom) throws Exception {
        ps=10;
        PageBean<AreaCustom> pb = new PageBean<>();
        PageHelper.startPage(pc, ps);//计算分页数据
        List<AreaCustom> myareaCustomList =  areaCustomMapper.selectAreaAndAreaListPic();

        try {

            pb.setBeanList(myareaCustomList);//将当前页显示的记录存入集合
            PageInfo<AreaCustom> info = new PageInfo<>(myareaCustomList);
            pb.setInfo(info);
            System.out.println(info);
            return pb;
        }catch (Exception e){
            throw new CustomException("对不起，由于系统原因，查询不到相关场地！");
        }
    }

    @Override
    public void deleteAreaById(Integer id) throws Exception {
        try {
            areaMapper.deleteByPrimaryKey(id);
        }catch (Exception e)
        {
            throw new CustomException("对不起，删除场地失败！请核对相关场地信息！");
        }

    }
    @Override
    public void saveArea(Area area) throws Exception {
        try{
            areaMapper.insertSelective(area);
        }catch (Exception e){
            /*throw new CustomException("对不起，由于系统原因增加场地出错！");*/
        }

    }

    @Override
    public void updateArea(Area area) throws Exception {
        try {
            areaMapper.updateByPrimaryKeyWithBLOBs(area);
        } catch (Exception e) {
            /*throw new CustomException("对不起，由于系统原因更新场地错误!");*/
        }
    }

    @Override
    public void updateAreaComment(Area area) throws Exception {
        try{
            areaMapper.updateByPrimaryKeySelective(area);
        }catch (Exception e){
            throw new CustomException("对不起,更新评论失败!");
        }
    }

    @Override
    public List<AreaCustom> selectAreaAndReserVation() throws Exception{
        List<AreaCustom> areaCustomList = areaCustomMapper.selectAreaAndReserVation();
        return areaCustomList;
    }

    //查询某个场地的具体信息
    @Override
    public AreaCustom findAreaDetail(Area area) throws Exception {
        try {
            return  areaCustomMapper.selectAreaAllInfo(area.getAreaId());
        }catch (Exception e){
            throw new CustomException("对不起，查询场地具体信息失败！");
        }
    }

    @Override
    public List<Area> findAllAreas1() throws Exception {
        AreaExample areaExample = new AreaExample();
        return areaMapper.selectByExampleWithBLOBs(areaExample);
    }

    @Override
    public List<AreaCustom> selectAreaReservation(Reservation reservation) throws Exception {
        try {
            return areaCustomMapper.selectAreaReservation(reservation);
        }catch (Exception e){
            throw new CustomException("对不起，查看场地的预约信息失败！");
        }
    }
}
