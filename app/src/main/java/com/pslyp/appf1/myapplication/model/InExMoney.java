package com.pslyp.appf1.myapplication.model;

/**
 * Created by User on 10/12/2560.
 */

public class InExMoney {

    private int id;
    private int picture;
    private String details;
    private int money;
    private String type;

    public InExMoney() {

    }

    public InExMoney(int id, int picture, String details, int money, String type) {
        this.id = id;
        this.picture = picture;
        this.details = details;
        this.money = money;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
