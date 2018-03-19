package com.netease.cart.vo;

import java.util.Date;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/24
 */
public class CartDetail {
    private Long pid;

    //标题
    private String title;

    private Float price;

    //购买数量
    private Integer count;

    private String img;

    private Date time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
