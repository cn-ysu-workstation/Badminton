package cn.yd.badminton.mapper;

import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.AppraisalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppraisalMapper {
    long countByExample(AppraisalExample example);

    int deleteByExample(AppraisalExample example);

    int deleteByPrimaryKey(Integer appraisalId);

    int insert(Appraisal record);

    int insertSelective(Appraisal record);

    List<Appraisal> selectByExampleWithBLOBs(AppraisalExample example);

    List<Appraisal> selectByExample(AppraisalExample example);

    Appraisal selectByPrimaryKey(Integer appraisalId);

    int updateByExampleSelective(@Param("record") Appraisal record, @Param("example") AppraisalExample example);

    int updateByExampleWithBLOBs(@Param("record") Appraisal record, @Param("example") AppraisalExample example);

    int updateByExample(@Param("record") Appraisal record, @Param("example") AppraisalExample example);

    int updateByPrimaryKeySelective(Appraisal record);

    int updateByPrimaryKeyWithBLOBs(Appraisal record);

    int updateByPrimaryKey(Appraisal record);
}