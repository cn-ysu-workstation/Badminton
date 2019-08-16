package cn.yd.badminton.service;

import cn.yd.badminton.po.Administrator;

public interface AdministratorService {
    public Administrator findUserByLogin(Administrator administrator) throws  Exception;
}
