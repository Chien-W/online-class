package com.even.oc.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.even.oc.common.Constants;
import com.even.oc.entity.User;
import com.even.oc.exception.ServiceException;
import com.even.oc.mapper.UserMapper;
import com.even.oc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/22 15:32
 * @Email : 1244843022@qq.com
 * @Description :
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {

    private static final Log LOG = Log.get();

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUser(String id) {
        return userMapper.findUser(id);
    }

    @Override
    public User login(User user){
        User one = getUserInfo(user);
        if (one != null) {
            BeanUtil.copyProperties(one, user, true);
            return one;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    private User getUserInfo(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getUserId());
        queryWrapper.eq("password", user.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}
