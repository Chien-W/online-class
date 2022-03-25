package com.even.oc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/22 16:26
 * @Email : 1244843022@qq.com
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }
}
