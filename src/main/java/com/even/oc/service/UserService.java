package com.even.oc.service;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.even.oc.entity.User;
import com.even.oc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/10 18:02
 * @Email : 1244843022@qq.com
 * @Description :
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public Boolean saveUser(User user) {
        return saveOrUpdate(user);//mybatis-plus提供的方法
    }
//    @Autowired
//    private UserMapper userMapper;
//
//    public Integer save(User user){
//        if (user.getId() == null){
//            return userMapper.insert(user);
//        }else{
//             return userMapper.update(user);
//        }
//    }


}
