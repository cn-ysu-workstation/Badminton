package cn.yd.badminton.service.impl;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.UserMapper;
import cn.yd.badminton.po.User;
import cn.yd.badminton.po.UserExample;
import cn.yd.badminton.po.UserExample.Criteria;
import cn.yd.badminton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserLogin(User user) throws Exception {

        UserExample userExample= new UserExample();
        Criteria criteria =userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<User> list=userMapper.selectByExample(userExample);
        if(list.size()<=0){
             throw  new CustomException("查无此人");
        }
        return list.get(0);

    }

    @Override
    public void toRegist(User user) {

        userMapper.insertSelective(user);
    }
}
