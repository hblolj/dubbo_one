package com.hblolj.dubbo.one.server.controller;

import com.hblolj.dubbo.one.api.enums.StatusCode;
import com.hblolj.dubbo.one.api.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hblolj
 * @Date: 2019/7/3 14:20
 * @Description:
 * @Version:
 **/
@Slf4j
@RestController
public class BaseController {

    private static final String prefix = "base";

    @GetMapping(value = prefix + "/one")
    public BaseResponse<String> one(@RequestParam String param){

        BaseResponse<String> response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            response.setData(param);
        }catch (Exception e){
            response = new BaseResponse<>(StatusCode.FAIL);
        }
        return response;
    }
}
