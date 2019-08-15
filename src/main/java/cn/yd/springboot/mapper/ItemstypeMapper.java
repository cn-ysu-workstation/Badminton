package cn.yd.springboot.mapper;

import cn.yd.springboot.po.Itemstype;
import cn.yd.springboot.po.ItemstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemstypeMapper {
    long countByExample(ItemstypeExample example);

    int deleteByExample(ItemstypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Itemstype record);

    int insertSelective(Itemstype record);

    List<Itemstype> selectByExample(ItemstypeExample example);

    Itemstype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Itemstype record, @Param("example") ItemstypeExample example);

    int updateByExample(@Param("record") Itemstype record, @Param("example") ItemstypeExample example);

    int updateByPrimaryKeySelective(Itemstype record);

    int updateByPrimaryKey(Itemstype record);
}