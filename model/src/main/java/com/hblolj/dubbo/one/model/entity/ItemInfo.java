package com.hblolj.dubbo.one.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "item_info")
public class ItemInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 销售价
     */
    private BigDecimal price;

    /**
     * 是否有效（1=是；0=否）
     */
    @Column(name = "is_active")
    private Integer isActive;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}