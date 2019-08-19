package cn.yd.badminton.service.impl;

<<<<<<< HEAD
import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaExample;
import cn.yd.badminton.po.PageBean;
import cn.yd.badminton.service.AreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
=======
import cn.yd.badminton.mapper.AdministratorMapper;
import cn.yd.badminton.mapper.AreaCustomMapper;
import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.service.AreaService;
>>>>>>> origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
<<<<<<< HEAD
    private AreaMapper areaMapper;

    @Override
    public Area findAreaById(Integer id) throws Exception {
        try {
            return areaMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            throw new CustomException("对不起，没有查询到此场地！");
        }
    }

    @Override
    public PageBean<Area> findAllAreas(Integer pc, Integer ps, Area area) throws Exception {
        PageBean<Area> pb = new PageBean<Area>();
        PageHelper.startPage(pc, ps);//计算分页数据

        AreaExample areaExample = new AreaExample();
        areaExample.setOrderByClause("id desc");
        //组合查询条件
        AreaExample.Criteria criteria = areaExample.createCriteria();
        //判断查询条件是否为null
        if(area!=null){
            if(area.getAreaname()!=null && !"".equals(area.getAreaname()))
            {
                criteria.andAreanameLike("%"+area.getAreaname()+"%");
                pb.setUrl("&areaname="+area.getAreaname());
            }
        }
        try {
            List<Area> areaList = areaMapper.selectByExampleWithBLOBs(areaExample);
            pb.setBeanList(areaList);//将当前页显示的记录存入集合
            PageInfo<Area> info = new PageInfo<Area>(areaList);
            pb.setInfo(info);
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
            throw new CustomException("对不起，由于系统原因增加场地出错！");
        }

    }

    @Override
    public void updateArea(Area area) throws Exception {
        try {
            areaMapper.updateByPrimaryKeyWithBLOBs(area);
        }catch (Exception e){
            throw new CustomException("对不起，由于系统原因更新场地错误!");
        }
=======
    private AreaCustomMapper areaCustomMapper;

    @Override
    public List<AreaCustom> selectAreaAndReserVation() throws Exception{
        List<AreaCustom> areaCustomList = areaCustomMapper.selectAreaAndReserVation();
        return areaCustomList;
>>>>>>> origin/master
    }
}
