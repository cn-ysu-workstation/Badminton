package cn.yd.badminton.service.impl;

import cn.yd.badminton.mapper.AdministratorMapper;
import cn.yd.badminton.mapper.AreaCustomMapper;
import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaCustomMapper areaCustomMapper;

    @Override
    public List<AreaCustom> selectAreaAndReserVation() throws Exception{
        List<AreaCustom> areaCustomList = areaCustomMapper.selectAreaAndReserVation();
        return areaCustomList;
    }
}
