package cn.yd.badminton.service;

import cn.yd.badminton.po.Administrator;


public interface AdministratorService {
     Administrator findUserByLogin(Administrator administrator) throws  Exception;
}
