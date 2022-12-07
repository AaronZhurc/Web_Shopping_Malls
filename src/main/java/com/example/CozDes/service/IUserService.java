package com.example.CozDes.service;

import com.example.CozDes.po.Userbean;

public interface IUserService {
    Userbean checkUser(String phone, String password);
    boolean regisUser(Userbean user);
    Userbean findUserByPhone(String phone);
}
