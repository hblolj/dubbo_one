package com.hblolj.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hblolj.dubbo.one.api.response.BaseResponse;
import com.hblolj.dubbo.one.api.service.IDubboItemService;
import com.hblolj.dubbo.one.model.entity.ItemInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: hblolj
 * @Date: 2019/7/3 15:49
 * @Description:
 * @Version:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboItemServiceTest {

    @Reference
    private IDubboItemService dubboItemService;

    @Test
    public void listItems() throws Exception {
        BaseResponse response = dubboItemService.listItems();
        List<ItemInfo> infos = (List<ItemInfo>) response.getData();
        System.out.println(infos);
        Assert.assertTrue(infos != null && infos.size() > 0);
    }

}