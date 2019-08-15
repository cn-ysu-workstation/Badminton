package cn.yd.badminton.mapper;

import cn.yd.badminton.po.Areapic;
import cn.yd.badminton.po.AreapicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreapicMapper {
    long countByExample(AreapicExample example);

    int deleteByExample(AreapicExample example);

    int deleteByPrimaryKey(Integer areapicId);

    int insert(Areapic record);

    int insertSelective(Areapic record);

    List<Areapic> selectByExample(AreapicExample example);

    Areapic selectByPrimaryKey(Integer areapicId);

    int updateByExampleSelective(@Param("record") Areapic record, @Param("example") AreapicExample example);

    int updateByExample(@Param("record") Areapic record, @Param("example") AreapicExample example);

    int updateByPrimaryKeySelective(Areapic record);

    int updateByPrimaryKey(Areapic record);
}