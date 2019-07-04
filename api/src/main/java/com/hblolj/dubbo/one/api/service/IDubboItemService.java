package com.hblolj.dubbo.one.api.service;

import com.hblolj.dubbo.one.api.response.BaseResponse;

/**
 * @author: hblolj
 * @Date: 2019/7/3 15:03
 * @Description:
 * @Version:
 **/
public interface IDubboItemService {

    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo, Integer pageSize);

    BaseResponse listPageItemsParams(Integer pageNo, Integer pageSize, String search);
}
