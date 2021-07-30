package com.kh.model.vo;

import java.io.Serializable;

public class ImportAccuseInfo extends Info implements Serializable {


    public ImportAccuseInfo(String taskNum, String name, String sort, String quantity, String price, String user, String phoneNum, String departure, String arrival) {
        super(taskNum, name, sort, quantity, price, user, phoneNum, departure, arrival);


    }


    @Override
    public String toString() {
        return "ExportAccuseInfo{" +
                "taskNum='" + getTaskNum() + '\'' +
                "name='" + getItem() + '\'' +
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
