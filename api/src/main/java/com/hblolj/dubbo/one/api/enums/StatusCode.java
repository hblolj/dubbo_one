package com.hblolj.dubbo.one.api.enums;

import lombok.Getter;

/**
 * @author: hblolj
 * @Date: 2019/7/3 14:17
 * @Description:
 * @Version:
 **/
@Getter
public enum  StatusCode {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    INVALID_PARAM(400, "无效的参数")
    ;

    private Integer code;

    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
