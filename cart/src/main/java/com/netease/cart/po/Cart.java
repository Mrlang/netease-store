/**generator自动生成类，不允许随意修改，添加字段*/
package com.netease.cart.po;

import java.util.Date;

public class Cart {
    private Long id;

    private Long pid;

    private Long uid;

    private Integer count;

    //是否已经清算
    private Integer cleared;

    //结算时的价格
    private Float buyedPrice;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCleared() {
        return cleared;
    }

    public void setCleared(Integer cleared) {
        this.cleared = cleared;
    }

    public Float getBuyedPrice() {
        return buyedPrice;
    }

    public void setBuyedPrice(Float buyedPrice) {
        this.buyedPrice = buyedPrice;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}