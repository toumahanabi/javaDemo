package com.example.javademo.expection;

import com.example.javademo.common.result.ResultCode;
import com.example.javademo.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public ResultData exception(Exception e, HttpServletRequest request){
        log.error("全局异常信息 ex={}", e.getMessage(), e);
//        return ResultData.fail(ResultCode.NOT_FOUND.getCode(), e.getMessage());
        return ResultData.fail(999, e.getMessage());
    }

}

