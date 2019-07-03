package com.hblolj.dubbo.one.api.response;

import com.hblolj.dubbo.one.api.enums.StatusCode;
import lombok.Data;

/**
 * @author: hblolj
 * @Date: 2019/7/3 14:17
 * @Description:
 * @Version:
 **/
@Data
public class BaseResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }
}
