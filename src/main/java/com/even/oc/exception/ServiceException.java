package com.even.oc.exception;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/22 16:41
 * @Email : 1244843022@qq.com
 * @Description :
 */
/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
