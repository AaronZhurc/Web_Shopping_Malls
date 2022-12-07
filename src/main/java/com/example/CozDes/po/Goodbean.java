package com.example.CozDes.po;

public class Goodbean {
    private int id;
    private String name;
    private double price;
    private String img;
    private String url;
    private String intro;
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Goodbean(int id, String name, double price, String img, String url, String intro, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.url = url;
        this.intro = intro;
        this.stock = stock;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Goodbean(int id, String name, double price, String img, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.url = url;
    }

    public Goodbean() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
