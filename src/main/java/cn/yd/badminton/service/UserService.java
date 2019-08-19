package cn.yd.badminton.service;

import cn.yd.badminton.po.User;

public interface UserService {

    User findUserLogin(User user) throws  Exception;

    void toRegist(User user);
}
