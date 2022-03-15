package com.even.oc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.even.oc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 *  @Project : online-class
 * @createTime : 2022/3/10 16:54
 * @Email : 1244843022@qq.com
 * @Description :
 */
//@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values (" +
//            "#{username},#{password},#{nickname},#{email},#{phone},#{address})")
////    Integer insert(User user);
//
//    //mybatis的动态sql
//    Integer update(User user);
//
//    @Delete("delete from sys_user where id=#{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like #{username} limit #{pageNum},#{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize,String username);
//
//    @Select("select count(*) from sys_user where username like #{username}")
//    Integer selectTotal(String username);
}
