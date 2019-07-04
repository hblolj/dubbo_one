package com.hblolj.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hblolj.dubbo.one.api.enums.StatusCode;
import com.hblolj.dubbo.one.api.response.BaseResponse;
import com.hblolj.dubbo.one.api.service.IDubboItemService;
import com.hblolj.dubbo.one.model.entity.ItemInfo;
import com.hblolj.dubbo.one.model.mapper.ItemInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import java.util.List;

/**
 * @author: hblolj
 * @Date: 2019/7/3 15:03
 * @Description:
 * @Version:
 **/
@Slf4j
@Path(value = "/dubbo_one")
@Service(protocol = {"dubbo", "rest"}, version = "1.0", timeout = 3000, validation = "true", loadbalance = "roundrobin")
public class DubboItemService implements IDubboItemService{

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Path(value = "item/list")
    @Override
    public BaseResponse listItems() {
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            List<ItemInfo> itemInfos = itemInfoMapper.selectAll();
            log.info("【listItems】, 获取到列表信息: {}", itemInfos);
            response.setData(itemInfos);
        }catch (Exception e){
            log.info("【listItems】，发生异常: {}", e.fillInStackTrace());
            response = new BaseResponse(StatusCode.FAIL);
        }
        return response;
    }

    @Path(value = "item/listPageItems")
    @Override
    public BaseResponse listPageItems(Integer pageNo, Integer pageSize) {
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            PageInfo<ItemInfo> itemInfos = PageHelper.startPage(pageNo, pageSize).doSelectPageInfo(() -> itemInfoMapper.selectAll());
            log.info("【listPageItems】, 获取到列表信息: {}", itemInfos);
            response.setData(itemInfos);
        }catch (Exception e){
            log.info("【listPageItems】，发生异常: {}", e.fillInStackTrace());
            response = new BaseResponse(StatusCode.FAIL);
        }
        return response;
    }

    @Path(value = "item/listPageItemsParams")
    @Override
    public BaseResponse listPageItemsParams(Integer pageNo, Integer pageSize, String search) {
        log.info("1 号服务!");
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            PageInfo<ItemInfo> itemInfos = PageHelper.startPage(pageNo, pageSize).doSelectPageInfo(() -> itemInfoMapper.selectAllByParams(search));
            log.info("【listPageItemsParams】, 获取到列表信息: {}", itemInfos);
            response.setData(itemInfos);
        }catch (Exception e){
            log.info("【listPageItemsParams】，发生异常: {}", e.fillInStackTrace());
            response = new BaseResponse(StatusCode.FAIL);
        }
        return response;
    }
}
