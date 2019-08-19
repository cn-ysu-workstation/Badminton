package cn.yd.badminton.service;

import cn.yd.badminton.po.Administrator;
import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.PageBean;

public interface AdministratorService {
    public Administrator findAdministartorByLogin(Administrator administrator) throws  Exception;


}
