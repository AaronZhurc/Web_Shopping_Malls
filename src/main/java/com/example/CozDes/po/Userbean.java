package com.example.CozDes.po;

public class Userbean {
    private int id;
    private String uname;
    private String password;
    private String phone;

    public Userbean() {
        super();
    }

    public Userbean(String uname, String password, String phone) {
        this.uname = uname;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
