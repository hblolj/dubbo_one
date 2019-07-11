package com.hblolj.dubbo.one.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_record")
public class OrderRecord {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品 id
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 数量
     */
    private Integer total;

    /**
     * 客户姓名
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 是否有效 (1=是; 0=否)
     */
    @Column(name = "is_active")
    private Integer isActive;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品 id
     *
     * @return item_id - 商品 id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置商品 id
     *
     * @param itemId 商品 id
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取数量
     *
     * @return total - 数量
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 设置数量
     *
     * @param total 数量
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 获取客户姓名
     *
     * @return customer_name - 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置客户姓名
     *
     * @param customerName 客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取是否有效 (1=是; 0=否)
     *
     * @return is_active - 是否有效 (1=是; 0=否)
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * 设置是否有效 (1=是; 0=否)
     *
     * @param isActive 是否有效 (1=是; 0=否)
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}