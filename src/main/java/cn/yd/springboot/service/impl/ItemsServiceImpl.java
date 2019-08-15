package cn.yd.springboot.service.impl;

import cn.yd.springboot.mapper.ItemsMapper;
import cn.yd.springboot.po.ItemsExample;
import cn.yd.springboot.po.Items;
import cn.yd.springboot.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findAllItems() throws Exception {
        ItemsExample itemsExample = new ItemsExample();
        return  itemsMapper.selectByExample(itemsExample);
    }

    @Override
    public void UpdateItems(Items items) throws Exception {
        itemsMapper.updateByPrimaryKey(items);
       /* int x=10/0;*/
    }
    @Override
    public Items getUserById(Integer id) throws Exception {
        return itemsMapper.selectByPrimaryKey(id);
    }
}
