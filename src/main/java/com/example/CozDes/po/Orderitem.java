package com.example.CozDes.po;

import java.util.Date;

public class Orderitem {
    String orderid;
    Date date;
    String status;

    public String getOrderid() {
        return orderid;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public Orderitem(String orderid, Date date, String status) {
        this.orderid = orderid;
        this.date = date;
        this.status = status;
    }
}
