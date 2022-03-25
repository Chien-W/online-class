package com.even.oc.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.even.oc.common.Constants;
import com.even.oc.common.Result;
import com.even.oc.entity.User;
import com.even.oc.mapper.UserMapper;
import com.even.oc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/10 17:17
 * @Email : 1244843022@qq.com
 * @Description :
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public User findUser(){
        return userService.findUser("1855010216");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String UserId = user.getUserId();
        String password = user.getPassword();
        System.out.println(user);
        if (StrUtil.isBlank(UserId) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(userService.login(user));
    }

//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public Boolean save(@RequestBody User user){
//        return userService.saveUser(user);
//    }
//
//    @GetMapping
//    public List<User> findAll(){
//        return userService.list();
//    }
//
//    @DeleteMapping("/{id}")
//    public Boolean delete(@PathVariable Integer id){
//        return userService.removeById(id);
//    }

    //分页查询
    //@RequestParam接收 ？pageNum=1&pageSize=10
    //limit第一个参数 = (pageNum-1)*pageSize
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String username){
//        pageNum=(pageNum-1)*pageSize;
//        username="%"+username+"%";
//        List<User> data = userMapper.selectPage(pageNum, pageSize,username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String, Object> map = new HashMap<>();
//        map.put("data",data);
//        map.put("total",total);
//        return map;
//    }
//    @GetMapping("/page")
//    public IPage<User> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam(defaultValue = "") String username){
//        IPage<User> page = new Page<>(pageNum,pageSize);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if(!("".equals(username))){
//            queryWrapper.like("username",username);
//        }
//        return userService.page(page,queryWrapper);
//    }
}
