package com.hblolj.dubbo.one.api.service;

import com.hblolj.dubbo.one.api.request.PushOrderDTO;
import com.hblolj.dubbo.one.api.response.BaseResponse;

/**
 * @author: hblolj
 * @Date: 2019/7/11 15:42
 * @Description:
 * @Version:
 **/
public interface IDubboOrderService {

    BaseResponse pushOrder(PushOrderDTO dto);
}
