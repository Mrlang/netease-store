package com.netease.store.vo;

import java.util.List;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/24
 */
public class BigCart {
    private Float totalPrice;

    private List<CartDetail> carts;

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartDetail> getCarts() {
        return carts;
    }

    public void setCarts(List<CartDetail> carts) {
        this.carts = carts;
    }
}
