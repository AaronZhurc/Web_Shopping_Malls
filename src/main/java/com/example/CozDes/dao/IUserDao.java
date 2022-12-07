package com.example.CozDes.dao;

import com.example.CozDes.po.Userbean;

public interface IUserDao {
    public Userbean selectBysome(String phone, String password);
    public boolean addUser(Userbean user);
    public Userbean findByPhone(String phone);
}
