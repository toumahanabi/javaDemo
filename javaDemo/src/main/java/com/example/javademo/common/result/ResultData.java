package com.example.javademo.common.result;

import lombok.Data;

@Data
public class ResultData<T> {

    // 结果状态码
    private int code;

    // 响应信息
    private String msg;

    // 响应数据
    private T data;

    // 接口请求时间
    private long timestamp ;

    public ResultData (){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData resultData = new ResultData();
        resultData.setCode(ResultCode.SUCCESS.getCode());
        resultData.setMsg(ResultCode.SUCCESS.getMessage());
        resultData.setData(data);
        return  resultData;
    }

    public static <T> ResultData<T> fail(int code, String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
}

