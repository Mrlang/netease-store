/**generator自动生成类，不允许随意修改，添加字段*/
package com.netease.store.po;

import java.util.Date;

public class Cart {
    private Long id;

    private Integer pid;

    private Integer uid;

    private Float price;

    private Integer count;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", pid=" + pid +
                ", uid=" + uid +
                ", price=" + price +
                ", count=" + count +
                ", created=" + created +
                '}';
    }
}