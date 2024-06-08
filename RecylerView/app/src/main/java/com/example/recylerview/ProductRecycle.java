package com.example.recylerview;

import android.widget.ImageView;

public class ProductRecycle {

    private String mName;
    private double price;
    private int quantity;

    public ProductRecycle( String mName, double price, int quantity) {
        this.mName = mName;
        this.price = price;
        this.quantity = quantity;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
