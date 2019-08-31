package cn.yd.badminton.mapper;
import cn.yd.badminton.po.AppraisalCustom;
import java.util.List;


public interface AppraisalCustomMapper {
    //显示某个场地的所有用户评价
    List<AppraisalCustom> selectAppraisalByareaid(Integer areaid);
    //某个用户查看自己的评价
    List<AppraisalCustom> selectAppraisalByuserid(Integer userid);
}
