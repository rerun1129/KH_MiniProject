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


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }



}
