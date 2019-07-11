package com.hblolj.dubbo.one.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: hblolj
 * @Date: 2019/7/11 15:43
 * @Description:
 * @Version:
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PushOrderDTO {

    /**
     * 商品 id
     */
    private Integer itemId;

    /**
     * 数量
     */
    private Integer total;

    /**
     * 客户姓名
     */
    private String customerName;
}
