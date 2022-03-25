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
public interface UserService{
    User findUser(String id);
    User login(User user);
}
