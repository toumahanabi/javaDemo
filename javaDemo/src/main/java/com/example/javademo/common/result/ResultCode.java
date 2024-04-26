package com.example.javademo.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    //成功提示码
    SUCCESS(200, "成功"),

    //未找到
    NOT_FOUND(400,"未找到"),

    //失败
    FAILURE(500, "失败");


    private final Integer code;
    private final String message;
}
