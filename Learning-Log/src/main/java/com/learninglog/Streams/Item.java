package com.learninglog.Streams;

import java.math.BigDecimal;

public class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item (String name , int qty , BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }


    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field
     *
     * @return qty
     */
    public int getQty() {
        return this.qty;
    }

    /**
     * set field
     *
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * get field
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * set field
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
