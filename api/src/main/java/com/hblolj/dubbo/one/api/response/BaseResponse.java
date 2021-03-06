package com.hblolj.dubbo.one.api.response;

import com.hblolj.dubbo.one.api.enums.StatusCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: hblolj
 * @Date: 2019/7/3 14:17
 * @Description:
 * @Version:
 **/
@Data
public class BaseResponse<T> implements Serializable{

    private static final long serialVersionUID = 5799434135135956302L;

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
