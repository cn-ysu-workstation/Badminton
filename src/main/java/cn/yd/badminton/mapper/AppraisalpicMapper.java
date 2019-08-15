package cn.yd.badminton.mapper;

import cn.yd.badminton.po.Appraisalpic;
import cn.yd.badminton.po.AppraisalpicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppraisalpicMapper {
    long countByExample(AppraisalpicExample example);

    int deleteByExample(AppraisalpicExample example);

    int deleteByPrimaryKey(Integer apppicId);

    int insert(Appraisalpic record);

    int insertSelective(Appraisalpic record);

    List<Appraisalpic> selectByExample(AppraisalpicExample example);

    Appraisalpic selectByPrimaryKey(Integer apppicId);

    int updateByExampleSelective(@Param("record") Appraisalpic record, @Param("example") AppraisalpicExample example);

    int updateByExample(@Param("record") Appraisalpic record, @Param("example") AppraisalpicExample example);

    int updateByPrimaryKeySelective(Appraisalpic record);

    int updateByPrimaryKey(Appraisalpic record);
}