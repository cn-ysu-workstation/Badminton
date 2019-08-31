package cn.yd.badminton.service;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.po.Areapic;

import java.util.List;

public interface AreaPicService {
    public void saveAreaPic(Areapic areapic) throws  Exception;
    public void updateAreaPic(Areapic areapic) throws  Exception;
    public List<Areapic> findByPrimaryId(Areapic areapic) throws  Exception;

    void deleAreaPic(Areapic areaph) throws CustomException;
}
