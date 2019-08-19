package cn.yd.badminton.controller;

//import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("stats")
public class StatsController {


    @RequestMapping(value="findAll",method={RequestMethod.POST})
    public String findStatsList(Integer pageNum,Integer pageSize) throws Exception{
//        PageHelper.startPage(pageNum,pageSize);//pageNum：当前页数   pageSize：当前页需要显示的数量
//        List<Blog> blogList = blogMapper.selectByExample(new BlogExample());
//        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
//        return pageInfo;

        //返回场地预览页面
        return "";
    }
//    public PageInfo<Blog> ajaxBlog(Integer pageNum,Integer pageSize){
//        PageHelper.startPage(pageNum,pageSize);//pageNum：当前页数   pageSize：当前页需要显示的数量
//        List<Blog> blogList = blogMapper.selectByExample(new BlogExample());
//        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
//        return pageInfo;
//    }
}
