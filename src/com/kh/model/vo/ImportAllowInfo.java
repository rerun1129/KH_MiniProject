package com.kh.model.vo;

import java.io.Serializable;

public class ImportAllowInfo extends Info implements Serializable {




    public ImportAllowInfo(String item, String sort, String quantity, String price, String user, String phoneNum, String departure, String arrival) {
        super(item, sort, quantity, price, user, phoneNum, departure, arrival);


    }


    @Override
    public String toString() {
        return "ImportAllowInfo{" +
                "item='" + getItem() + '\'' +
                ", sort='" + getSort() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", user='" + getUser() + '\'' +
                ", phoneNum='" + getPhoneNum() + '\'' +
                ", departure='" + getDeparture() + '\'' +
                ", arrival='" + getArrival() + '\'' +
                '}';
    }
}
