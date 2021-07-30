package com.kh.model.vo;

import java.io.Serializable;

public class Info implements Serializable {
    private String taskNum;
    private String item;
    private String sort;
    private String quantity;
    private String price;
    private String user;
    private String phoneNum;
    private String departure;
    private String arrival;


    public Info() {

    }

    @Override
    public String toString() {
        return "Info{" +
                "item='" + item + '\'' +
                ", sort='" + sort + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", user='" + user + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                '}';
    }

    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    public Info(String taskNum, String item, String sort, String quantity, String price, String user, String phoneNum,
                String departure, String arrival) {
        this.taskNum = taskNum;
        this.item = item;
        this.sort = sort;
        this.quantity = quantity;
        this.price = price;
        this.user = user;
        this.phoneNum = phoneNum;
        this.departure = departure;
        this.arrival = arrival;


    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }


}
