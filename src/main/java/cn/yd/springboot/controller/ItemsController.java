package cn.yd.springboot.controller;

import cn.yd.springboot.po.Items;
import cn.yd.springboot.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/getAllItems")
    public List<Items> getAllItems() throws Exception {
        List<Items> itemsList = new ArrayList<Items>();
        itemsList = itemsService.findAllItems();
        return  itemsList;
    }

    @RequestMapping("/updateItems")
    public void updateItems()throws  Exception{
        Items items = new Items();
        items.setId(4);
        items.setName("机械键盘");
        items.setPrice(BigDecimal.valueOf(600));
        itemsService.UpdateItems(items);
    }

    @RequestMapping("/getItemsById/{id}")
    public Items getItemsById(@PathVariable("id") Integer id) throws Exception {
        return itemsService.getUserById(id);
    }

    @RequestMapping("/showItems/id/{id}/name/{name}/price/{price}")
    public String showItems(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("price") Integer price)throws  Exception{
        return  "id"+id+"----"+"name"+name+"-------"+"price"+price+"真的好用";
    }
}
