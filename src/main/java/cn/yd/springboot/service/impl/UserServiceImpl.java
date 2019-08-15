package cn.yd.springboot.service.impl;

import cn.yd.springboot.mapper.UserMapper;
import cn.yd.springboot.po.User;
import cn.yd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }
}
