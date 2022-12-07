package com.example.CozDes.po;

import com.example.CozDes.service.GoodService;
import com.example.CozDes.service.IGoodService;

import java.util.Date;

public class Cartitem {
    String id;
    Goodbean good;
    int num;
    String dest;
    double price;

    public String getId() {
        return id;
    }

    public Goodbean getGood() {
        return good;
    }

    public int getNum() {
        return num;
    }

    public String getDest() {
        return dest;
    }

    public double getPrice() {
        return price;
    }

    public Cartitem(String url, int num, String dest) {
        IGoodService gs=new GoodService();
        this.good=gs.getGood(url);
        this.num = num;
        this.dest = dest;
        this.price=num*this.good.getPrice();
        this.id=url+"_"+new Date().getTime();
    }
    public Cartitem(int gid, int num, String dest, String id) {
        IGoodService gs=new GoodService();
        this.good=gs.getGood(gid);
        this.num = num;
        this.dest = dest;
        this.price=num*this.good.getPrice();
        this.id=id;
    }
}
