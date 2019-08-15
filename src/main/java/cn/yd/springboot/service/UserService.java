package cn.yd.springboot.service;

import cn.yd.springboot.po.User;

public interface UserService {
    public User getUserById(Integer id) throws  Exception;
}
