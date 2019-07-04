package com.hblolj.dubbo.one.model.mapper;

import com.hblolj.dubbo.one.model.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemInfoMapper extends Mapper<ItemInfo> {

    List<ItemInfo> selectAll();

    List<ItemInfo> selectAllByParams(@Param("search") String search);
}