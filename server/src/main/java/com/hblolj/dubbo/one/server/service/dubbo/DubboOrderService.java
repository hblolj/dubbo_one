package com.hblolj.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.hblolj.dubbo.one.api.enums.StatusCode;
import com.hblolj.dubbo.one.api.request.PushOrderDTO;
import com.hblolj.dubbo.one.api.response.BaseResponse;
import com.hblolj.dubbo.one.api.service.IDubboOrderService;
import com.hblolj.dubbo.one.model.entity.ItemInfo;
import com.hblolj.dubbo.one.model.entity.OrderRecord;
import com.hblolj.dubbo.one.model.mapper.ItemInfoMapper;
import com.hblolj.dubbo.one.model.mapper.OrderRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * @author: hblolj
 * @Date: 2019/7/11 15:48
 * @Description:
 * @Version:
 **/
@Slf4j
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
@Path("record")
public class DubboOrderService implements IDubboOrderService{

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    @Path("push")
    @Override
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse pushOrder(PushOrderDTO dto) {

        if (dto.getItemId() == null || dto.getItemId() < 0 || StringUtils.isEmpty(dto.getCustomerName())
                || dto.getTotal() == null){
            return new BaseResponse(StatusCode.INVALID_PARAM);
        }

        log.info("【下单】, dto: {}", dto);
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);

        ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(dto.getItemId());
        if (itemInfo == null){
            return new BaseResponse(StatusCode.ItemNotExist);
        }

        try {
            OrderRecord orderRecord = new OrderRecord();
            BeanUtils.copyProperties(dto, orderRecord);
            orderRecord.setOrderTime(new Date());
            orderRecordMapper.insertOrder(orderRecord);
            response.setData(orderRecord.getId());
        }catch (Exception e){
            e.printStackTrace();
            response = new BaseResponse(StatusCode.FAIL.getCode(), e.getMessage(), null);
        }

        return response;
    }
}
