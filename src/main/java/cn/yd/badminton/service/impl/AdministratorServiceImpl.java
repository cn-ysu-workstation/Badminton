package cn.yd.badminton.service.impl;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.AdministratorMapper;
import cn.yd.badminton.mapper.AreaMapper;
import cn.yd.badminton.po.*;
import cn.yd.badminton.service.AdministratorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public Administrator findAdministartorByLogin(Administrator administrator) throws Exception {
        AdministratorExample administratorExample = new AdministratorExample();
        AdministratorExample.Criteria criteria = administratorExample.createCriteria();
        criteria.andUsernameEqualTo(administrator.getUsername());
        criteria.andPasswordEqualTo(administrator.getPassword());
        List<Administrator> administratorList = administratorMapper.selectByExample(administratorExample);
        if(administratorList.size()<=0)
        {
            throw new CustomException("对不起，查无此人，请重新输入账号和密码！");
        }
        return administratorList.get(0);
    }
}
