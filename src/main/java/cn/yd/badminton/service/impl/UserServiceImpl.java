package cn.yd.badminton.service.impl;

import cn.yd.badminton.exception.CustomException;
import cn.yd.badminton.mapper.UserMapper;
import cn.yd.badminton.po.PageBean;
import cn.yd.badminton.po.User;
import cn.yd.badminton.po.UserExample;
import cn.yd.badminton.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserLogin(User user) throws Exception {

        UserExample userExample= new UserExample();
        UserExample.Criteria criteria =userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<User> list=userMapper.selectByExample(userExample);
        if(list.size()<=0){
             throw  new CustomException("用户名密码不匹配~~~");
        }
        return list.get(0);

    }

    @Override
    public void toRegist(User user) {

        userMapper.insertSelective(user);
    }

    @Override
    public List<User> findUser(String username) throws Exception {
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria =userExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<User> list=userMapper.selectByExample(userExample);

        return list;
    }



    @Override
    public PageBean<User> findAllUsers(Integer pc, Integer ps, User user) throws Exception {

        PageBean<User> pb = new PageBean<User>();
        PageHelper.startPage(pc,ps);//计算分页数据

        UserExample userExample = new UserExample();
        userExample.setOrderByClause("user_ID desc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andDelStatusEqualTo(0);
        if(user!=null)
        {
            if(user.getName()!=null && !"".equals(user.getName()))
            {
                criteria.andNameLike("%"+user.getName()+"%");
                pb.setUrl("&name="+user.getName());
            }
        }
        try{

            List<User> userList = userMapper.selectByExample(userExample);
            pb.setBeanList(userList);
            PageInfo<User> info = new PageInfo<User>(userList);
            pb.setInfo(info);
            return pb;
        }catch (Exception e) {
            throw new CustomException("对不起，查询出现错误！");
        }
    }

    @Override
    public void updateUser(User user) throws Exception {
        try {
            User tmp_user = new User();
            tmp_user = userMapper.selectByPrimaryKey(user.getUserId());
            tmp_user.setUsername(user.getUsername());
            tmp_user.setPassword(user.getPassword());
            tmp_user.setName(user.getName());
            tmp_user.setSex(user.getSex());
            tmp_user.setPhonenumber(user.getPhonenumber());
            tmp_user.setPriceStatus(user.getPriceStatus());
            userMapper.updateByPrimaryKey(tmp_user);
        }catch (Exception e) {
            throw new CustomException("对不起，更新用户失败！");
        }
    }

    @Override
    public void userupdateUser(User user) throws Exception {
        try {
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e) {
            throw new CustomException("对不起，更新用户失败！");
        }

    }

    @Override
    public void deleteUser(User user) throws Exception {
        try {
            user = userMapper.selectByPrimaryKey(user.getUserId());
            user.setDelStatus(1);
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e){
            throw new CustomException("对不起，删除用户失败!");
        }
    }
}
