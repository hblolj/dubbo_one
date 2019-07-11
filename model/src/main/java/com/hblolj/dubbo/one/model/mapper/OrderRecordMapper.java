package com.hblolj.dubbo.one.model.mapper;

import com.hblolj.dubbo.one.model.entity.OrderRecord;
import tk.mybatis.mapper.common.Mapper;

public interface OrderRecordMapper extends Mapper<OrderRecord> {

    Integer insertOrder(OrderRecord orderRecord);
}