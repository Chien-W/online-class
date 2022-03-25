package com.even.oc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/10 16:50
 * @Email : 1244843022@qq.com
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "users")
@ToString
public class User {
    @TableId
    private String userId;
    private String email;
    private Integer submit;
    private Integer solved;
    private String defunct;
    private String ip;
    private Date accesstime;
    private Integer volume;
    private Integer language;
    private String password;
    private Date regTime;
    private String nick;
    private String school;
    private String classId;
    private String college;
    private String name;
    private String contact;
    private String number;
    private Integer sex;
    private String major;
//@TableField(value="")指定表的字段名，驼峰已经自动装
}
