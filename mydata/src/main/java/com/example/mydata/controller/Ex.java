package com.example.mydata.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;

@ControllerAdvice(basePackageClasses={MyTaskController.class})
public class Ex {



    /**
     * 处理 BusinessException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SocketTimeoutException.class)
    public String businessExceptionHandler(HttpServletRequest httpServletRequest, SocketTimeoutException e) {
        System.out.println("业务异常。code:" + e.getMessage());
        return "当前访问人数较多，请稍候";
    }

}
