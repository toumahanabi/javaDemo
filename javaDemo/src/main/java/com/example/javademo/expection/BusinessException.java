package com.example.javademo.expection;

import com.example.javademo.common.result.ResultCode;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private int code;
    private String msg;

    public BusinessException() {
    }

    public BusinessException(ResultCode resultCode) {
        this(resultCode.getCode(),resultCode.getMessage());
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}

