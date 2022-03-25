package com.even.oc.exception;

import com.even.oc.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : yfxie
 * @version : 1.0
 * @Project : online-class
 * @createTime : 2022/3/23 15:00
 * @Email : 1244843022@qq.com
 * @Description :
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 如果抛出的的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return Result
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(), se.getMessage());
    }

}
