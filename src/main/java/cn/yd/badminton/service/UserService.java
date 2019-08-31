package cn.yd.badminton.service;

import cn.yd.badminton.po.PageBean;
import cn.yd.badminton.po.User;

import java.util.List;

public interface UserService {

    User findUserLogin(User user) throws  Exception;

    void toRegist(User user) throws  Exception;

    List<User> findUser(String username) throws Exception;

    PageBean<User> findAllUsers(Integer pc,Integer ps,User user) throws Exception;

    void updateUser(User user) throws  Exception;

    void deleteUser(User user) throws  Exception;

     void userupdateUser(User user)throws  Exception;

}
