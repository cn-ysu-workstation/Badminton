package cn.yd.springboot.service;

import cn.yd.springboot.po.Items;

import java.util.List;

public interface ItemsService {
    public List<Items> findAllItems() throws Exception;
    public void UpdateItems(Items items) throws  Exception;
    public Items getUserById(Integer id) throws  Exception;
}
