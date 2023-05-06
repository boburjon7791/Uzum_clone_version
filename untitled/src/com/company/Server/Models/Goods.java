package com.company.Server.Models;


import com.company.Server.Enums.GoodsType;

import java.util.UUID;

public class Goods {
    private String name;
    private String color;
    private double price;
    private double quantity;
    private String comments;
    private String aboutGood;
    private boolean isExistent=true;
    private boolean isActive=true;
    final UUID uuid = UUID.randomUUID();
    private final String id = String.valueOf(uuid);

    private GoodsType goodsType;
    public String getId() {
        return id;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Goods() {
    }

    public Goods(String name, String color, double price,
                 double quantity, String aboutGood, boolean isExistent,GoodsType goodsType) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.aboutGood = aboutGood;
        this.quantity = quantity;
        this.isExistent = isExistent;
        this.goodsType = goodsType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAboutGood() {
        return aboutGood;
    }

    public void setAboutGood(String aboutGood) {
        this.aboutGood = aboutGood;
    }

    public boolean isExistent() {
        return isExistent;
    }


    public void setExistent(boolean existent) {
        isExistent = existent;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", comments='" + comments + '\'' +
                ", aboutGood='" + aboutGood + '\'' +
                ", isExistent=" + isExistent +
                '}';
    }
}

